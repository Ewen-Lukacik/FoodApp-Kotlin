package com.example.foodapp_kotlin.ui.viewmodel

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp_kotlin.auth.PasswordUtils
import com.example.foodapp_kotlin.auth.SessionManager
import com.example.foodapp_kotlin.local.database.AppDatabase
import com.example.foodapp_kotlin.local.entity.User
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AuthResult {
    object Success : AuthResult()
    data class Error(val message: String) : AuthResult()
}

class AuthViewModel(app: Application) : AndroidViewModel(app) {

    private val db = AppDatabase.getInstance(app)
    private val session = SessionManager(app)

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _authResult = MutableSharedFlow<AuthResult>()
    val authResult: SharedFlow<AuthResult> = _authResult.asSharedFlow()

    val isLoggedIn: Boolean get() = session.isLoggedIn()

    init {
        restoreSession()
    }

    private fun restoreSession() {
        val savedId = session.getSavedUserId()
        if (savedId != SessionManager.NO_USER) {
            viewModelScope.launch {
                _currentUser.value = db.userDao().getUserById(savedId)
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val trimmedEmail = email.trim().lowercase()
            val user = db.userDao().getUserByEmail(trimmedEmail)
            if (user == null) {
                _authResult.emit(AuthResult.Error("Aucun compte trouvé avec cet e-mail."))
                return@launch
            }
            if (!PasswordUtils.verify(password, user.salt, user.passwordHash)) {
                _authResult.emit(AuthResult.Error("Mot de passe incorrect."))
                return@launch
            }
            session.saveSession(user.id)
            _currentUser.value = user
            _authResult.emit(AuthResult.Success)
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String) {
        viewModelScope.launch {
            val trimmedEmail = email.trim().lowercase()
            if (db.userDao().getUserByEmail(trimmedEmail) != null) {
                _authResult.emit(AuthResult.Error("Un compte existe déjà avec cet e-mail."))
                return@launch
            }
            val salt = PasswordUtils.generateSalt()
            val hash = PasswordUtils.hashPassword(password, salt)
            val user = User(
                firstName = firstName,
                lastName = lastName,
                email = trimmedEmail,
                passwordHash = hash,
                salt = salt
            )
            try {
                val newId = db.userDao().insertUser(user).toInt()
                val created = db.userDao().getUserById(newId)!!
                session.saveSession(created.id)
                _currentUser.value = created
                _authResult.emit(AuthResult.Success)
            } catch (e: SQLiteConstraintException) {
                _authResult.emit(AuthResult.Error("Un compte existe déjà avec cet e-mail."))
            }
        }
    }

    fun updateProfile(firstName: String, lastName: String, email: String, phone: String) {
        viewModelScope.launch {
            val current = _currentUser.value ?: return@launch
            val updated = current.copy(
                firstName = firstName,
                lastName = lastName,
                email = email.trim().lowercase(),
                phone = phone
            )
            db.userDao().updateUser(updated)
            _currentUser.value = updated
            _authResult.emit(AuthResult.Success)
        }
    }

    fun logout() {
        session.clearSession()
        _currentUser.value = null
    }
}
