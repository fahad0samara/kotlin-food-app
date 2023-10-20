package com.example.foodapp.navgtion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodapp.screen.CartScreen
import com.example.foodapp.screen.HomeScreen
import com.example.foodapp.screen.ProfileScreen
import com.example.foodapp.screen.SettingsScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController, BottomBarScreen.Home.route,
        route = Graph.HOME
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                navController = navController,
            )
        }
        composable(route = BottomBarScreen.Cart.route) {
            CartScreen()

        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(
                navController = navController
            )

        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(
                navController = navController
            )


        }

        FoodScreenGraph(navController = navController)



    }
}



