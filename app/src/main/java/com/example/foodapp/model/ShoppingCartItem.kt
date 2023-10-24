package com.example.foodapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "cart_items")
data class ShoppingCartItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

    val food: Int,
    var quantity: Int
)