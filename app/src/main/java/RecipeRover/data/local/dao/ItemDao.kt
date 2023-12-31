package com.fahad.RecipeRover.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fahad.RecipeRover.data.local.entities.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert
    suspend fun insert(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT title FROM items")
    suspend fun getAllItemNames(): List<String>

    @Query("SELECT * FROM items WHERE id = :itemId")
    suspend fun getItemById(itemId: Long): Item?

    @Delete
    suspend fun delete(item: Item)

    @Query("DELETE FROM items")
    suspend fun deleteAllItems()

    @Query("UPDATE items SET quantity = quantity + 1 WHERE id = :itemId")
    suspend fun incrementItemQuantity(itemId: Long)

    @Query("UPDATE items SET quantity = quantity - 1 WHERE id = :itemId")
    suspend fun decrementItemQuantity(itemId: Long)



}

