package com.example.foodapp.model

import com.example.foodapp.data.Food

data class ShoppingCartItem(
    val food: Food,
    var quantity: Int
)