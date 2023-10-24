package com.example.foodapp.screen



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodapp.model.ShoppingCartItem
import com.example.foodapp.model.ShoppingCartViewModel




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(cartViewModel: ShoppingCartViewModel) {
    val cartItems by cartViewModel.cartItems.collectAsState(emptyList()) // Collect the cart items

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Cart") }
            )
        }
    ) { paddings ->
        if (cartItems.isEmpty()) {
            // Display a message when the cart is empty
            Text(
                text = "Your cart is empty",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),

                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddings)
            ) {
                items(cartItems) { cartItem ->
                    CartItemRow(cartItem)
                }
            }
        }
    }
}

@Composable
fun CartItemRow(cartItem: ShoppingCartItem) {
    // Display cart item details
    Text(
        text = "Food ID: ${cartItem.food}, Quantity: ${cartItem.quantity}",
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        fontWeight = FontWeight.Bold
    )
}
