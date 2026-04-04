package com.example.foodapp_kotlin.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.foodapp_kotlin.local.entity.User
import com.example.foodapp_kotlin.local.entity.UserFavorite

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM User WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM User WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Int): User?

    @Update
    suspend fun updateUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserFavorite(userFavorite: UserFavorite)

    @Query("DELETE FROM UserFavorite WHERE userId = :userId AND recipeId = :recipeId")
    suspend fun removeUserFavorite(userId: Int, recipeId: Int)

    @Query("SELECT recipeId FROM UserFavorite WHERE userId = :userId")
    suspend fun getFavoriteRecipeIds(userId: Int): List<Int>
}
