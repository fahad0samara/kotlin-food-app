package com.example.foodapp.navgtion



import android.content.Context
import androidx.compose.material3.Scaffold
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




@Composable
fun Navigation() {}




//  NavHost(navController = navController, startDestination = "home") {
//
//        composable("Splash"){
//            SplashScreen(navController = navController)
//        }
//        composable("home"){
//            HomeScreen(navController = navController)
//        }
//      composable("Search"){
//          SearchScreen(navController = navController)
//      }
//        composable("food/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
//            val selectedFood = foods.find { it.id == navController.currentBackStackEntry?.arguments?.getInt("id") } ?: foods[0]
//            FoodScreen(navController = navController, selectedFood = selectedFood)
//        }
//    }
//
//
//}














