package com.example.foodapp_kotlin.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp_kotlin.local.database.AppDatabase
import com.example.foodapp_kotlin.local.entity.Category
import com.example.foodapp_kotlin.local.entity.Comment
import com.example.foodapp_kotlin.local.entity.Ingredient
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.local.relation.CategoryWithRecipes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(app: Application) : AndroidViewModel(app) {

    private val db = AppDatabase.getInstance(app)

    private val _categoriesWithRecipes = MutableStateFlow<List<CategoryWithRecipes>>(emptyList())
    val categoriesWithRecipes: StateFlow<List<CategoryWithRecipes>> = _categoriesWithRecipes.asStateFlow()

    private val _recipesForCategory = MutableStateFlow<List<Recipe>>(emptyList())
    val recipesForCategory: StateFlow<List<Recipe>> = _recipesForCategory.asStateFlow()

    private val _categoryName = MutableStateFlow("")
    val categoryName: StateFlow<String> = _categoryName.asStateFlow()

    // All categories for the search screen
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories.asStateFlow()

    // Search results
    private val _searchResults = MutableStateFlow<List<Recipe>>(emptyList())
    val searchResults: StateFlow<List<Recipe>> = _searchResults.asStateFlow()

    // Recipe detail
    private val _selectedRecipe = MutableStateFlow<Recipe?>(null)
    val selectedRecipe: StateFlow<Recipe?> = _selectedRecipe.asStateFlow()

    private val _recipeIngredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val recipeIngredients: StateFlow<List<Ingredient>> = _recipeIngredients.asStateFlow()

    private val _recipeCategories = MutableStateFlow<List<Category>>(emptyList())
    val recipeCategories: StateFlow<List<Category>> = _recipeCategories.asStateFlow()

    private val commentDao = db.commentDao()
    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments: StateFlow<List<Comment>> = _comments.asStateFlow()

    init {
        viewModelScope.launch {
            _categoriesWithRecipes.value = db.categoryDao().getCategoriesWithRecipes()
            _categories.value = db.categoryDao().getAllCategories()
        }
    }

    fun loadComments(recipeId: Int){
        viewModelScope.launch {
            commentDao.getCommentsForRecipe(recipeId).collect { list ->
                _comments.value = list
            }
        }
    }

    fun addComment(recipeId: Int, userId: Int, authorName: String, content: String){
        if(content.isBlank()) return
        viewModelScope.launch {
            commentDao.insertComment(
                Comment(
                    recipeId = recipeId,
                    userId = userId,
                    authorName = authorName,
                    content = content
                )
            )
        }
    }

    fun loadRecipesForCategory(categoryId: Int) {
        viewModelScope.launch {
            val categories = db.categoryDao().getAllCategories()
            _categoryName.value = categories.find { it.id == categoryId }?.name ?: ""
            _recipesForCategory.value = db.recipeDao().getAllRecipesFromCategory(categoryId)
        }
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            _searchResults.value = if (query.isBlank()) {
                emptyList()
            } else {
                db.recipeDao().searchRecipesByName(query)
            }
        }
    }

    fun getRecipeCountForCategory(categoryId: Int): Int {
        return _categoriesWithRecipes.value.find { it.category.id == categoryId }?.recipes?.size ?: 0
    }

    fun loadRecipeDetail(recipeId: Int) {
        viewModelScope.launch {
            _selectedRecipe.value = db.recipeDao().getRecipeById(recipeId)
            _recipeIngredients.value = db.recipeDao().getRecipeWithIngredients(recipeId)?.ingredients ?: emptyList()
            _recipeCategories.value = db.recipeDao().getRecipeWithCategories(recipeId)?.categories ?: emptyList()
        }
    }
}
