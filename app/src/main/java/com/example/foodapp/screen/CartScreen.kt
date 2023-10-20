package com.example.foodapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodapp.model.ShoppingCartItem
import com.example.foodapp.model.ShoppingCartViewModel

@Composable
fun CartScreen() {
    val cartViewModel: ShoppingCartViewModel = viewModel()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Cart",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        cartViewModel.cartItems.forEach { cartItem ->
            Text(
                text = "${cartItem.food.name} x ${cartItem.quantity}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "Total: ${cartViewModel}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}











