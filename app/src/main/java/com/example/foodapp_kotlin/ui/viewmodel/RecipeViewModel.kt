package com.example.foodapp_kotlin.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp_kotlin.local.database.AppDatabase
import com.example.foodapp_kotlin.local.relation.CategoryWithRecipes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(app: Application) : AndroidViewModel(app) {

    private val db = AppDatabase.getInstance(app)

    private val _categoriesWithRecipes = MutableStateFlow<List<CategoryWithRecipes>>(emptyList())
    val categoriesWithRecipes: StateFlow<List<CategoryWithRecipes>> = _categoriesWithRecipes.asStateFlow()

    init {
        viewModelScope.launch {
            _categoriesWithRecipes.value = db.categoryDao().getCategoriesWithRecipes()
        }
    }
}
