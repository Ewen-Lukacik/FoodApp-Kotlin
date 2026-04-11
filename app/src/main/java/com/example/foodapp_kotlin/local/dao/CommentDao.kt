package com.example.foodapp_kotlin.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodapp_kotlin.local.entity.Comment
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {
    @Query("SELECT * FROM Comment WHERE recipeId = :recipeId ORDER BY createdAt DESC")
    fun getCommentsForRecipe(recipeId: Int): Flow<List<Comment>>

    @Insert
    suspend fun insertComment(comment: Comment)

    @Delete
    suspend fun deleteComment(comment: Comment)
}