package com.fahad.RecipeRover.data.local.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import RecipeRover.data.local.entities.FavoriteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insert(favoriteItem: FavoriteItem)

    @Query("SELECT * FROM favorites")
    fun getFavoriteItems(): Flow<List<FavoriteItem>>

    @Delete
    suspend fun delete(favoriteItem: FavoriteItem)

    @Query("DELETE FROM favorites")
    suspend fun deleteAllFavoriteItems()

    @Query("SELECT EXISTS (SELECT 1 FROM favorites WHERE title = :bookTitle LIMIT 1)")
    fun isBookInFavorites(bookTitle: String): Flow<Boolean>
}
