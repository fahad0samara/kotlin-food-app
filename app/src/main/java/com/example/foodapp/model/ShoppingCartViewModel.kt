package com.example.foodapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.foodapp.data.Food

import com.example.foodapp.model.local.AppDatabase

import kotlinx.coroutines.flow.Flow


class ShoppingCartViewModel(application: Application) : AndroidViewModel(application) {
    private val cartItemDao = AppDatabase.getInstance(application).cartItemDao()


    val cartItems: Flow<List<ShoppingCartItem>> = cartItemDao.getAllCartItems()

    fun getCartItem(food: Int): ShoppingCartItem? {
        return cartItemDao.getCartItem(food)
    }

    fun insertOrUpdateCartItem(cartItem: ShoppingCartItem) {
        cartItemDao.insertOrUpdateCartItem(cartItem)
    }

    fun deleteCartItem(food: Int) {
        cartItemDao.deleteCartItem(food)
    }

    // Add an item to the cart
    fun addItem(food: Int) {
        val cartItem = getCartItem(food)
        if (cartItem == null) {
            insertOrUpdateCartItem(ShoppingCartItem(food = food, quantity = 1))
        } else {
            insertOrUpdateCartItem(cartItem.copy(quantity = cartItem.quantity + 1))
        }
    }













}



