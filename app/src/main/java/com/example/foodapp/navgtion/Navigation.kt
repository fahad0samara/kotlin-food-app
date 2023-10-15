package com.example.foodapp.navgtion



import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodapp.data.foods
import com.example.foodapp.screen.FoodScreen
import com.example.foodapp.screen.HomeScreen
import com.example.foodapp.screen.SplashScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)
    val userLoggedIn = sharedPreferences.getBoolean("loggedIn",false)
    NavHost(navController = navController, startDestination = if (userLoggedIn) "home" else "auth"){

        composable("Splash"){
            SplashScreen(navController = navController)
        }
        composable("home"){
            HomeScreen(navController = navController)
        }
        composable("food/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
            val selectedFood = foods.find { it.id == navController.currentBackStackEntry?.arguments?.getInt("id") } ?: foods[0]
            FoodScreen(navController = navController, selectedFood = selectedFood)
        }
    }
}