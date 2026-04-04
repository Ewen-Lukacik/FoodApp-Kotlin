package com.example.foodapp_kotlin.auth

import android.content.Context

class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_USER_ID = "logged_in_user_id"
        const val NO_USER = -1
    }

    fun saveSession(userId: Int) {
        prefs.edit().putInt(KEY_USER_ID, userId).apply()
    }

    fun getSavedUserId(): Int = prefs.getInt(KEY_USER_ID, NO_USER)

    fun clearSession() {
        prefs.edit().remove(KEY_USER_ID).apply()
    }

    fun isLoggedIn(): Boolean = getSavedUserId() != NO_USER
}
