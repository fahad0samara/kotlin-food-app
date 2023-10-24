package com.example.foodapp.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.model.ShoppingCartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateCartItem(cartItem: ShoppingCartItem)

    @Query("SELECT * FROM cart_items")
    fun getAllCartItems(): Flow<List<ShoppingCartItem>>

    @Query("SELECT * FROM cart_items WHERE food = :food")
fun getCartItem(food: Int): ShoppingCartItem?

    @Query("DELETE FROM cart_items WHERE food = :food")
 fun deleteCartItem(food: Int)




}