package com.example.foodapp.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.Food

class ShoppingCartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<ShoppingCartItem>()

    fun addItemToCart(food: Food) {
        // Check if the item is already in the cart
        val existingItemIndex = cartItems.indexOfFirst { it.food.id == food.id }
        if (existingItemIndex >= 0) {
            val existingItem = cartItems[existingItemIndex]
            cartItems[existingItemIndex] = existingItem.copy(quantity = existingItem.quantity + 1)



        } else {
            cartItems.add(ShoppingCartItem(food = food, quantity = 1))


        }
    }


}
