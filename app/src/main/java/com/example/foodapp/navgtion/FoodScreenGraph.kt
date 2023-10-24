package com.example.foodapp.navgtion



import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType

import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import androidx.navigation.navigation
import com.example.foodapp.data.foods

import com.example.foodapp.screen.FoodScreen

fun NavGraphBuilder.FoodScreenGraph(navController: NavHostController) {
    navigation(
        route = Graph.FOOD,
        startDestination = DetailsScreen.Food.route
    ) {
        composable(
            route = DetailsScreen.Food.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            // Add a Log statement to check the selectedFoodId
            val selectedFoodId = backStackEntry.arguments?.getInt("id")


            // Use selectedFoodId to find the selected food item
            val selectedFood = selectedFoodId?.let { foodId ->
                foods.find { it.id == foodId }
            }



            // Check if selectedFood is not null and navigate to FoodScreen
            selectedFood?.let {
                FoodScreen(navController = navController, selectedFood = it)
            }}
        }
    }





sealed class DetailsScreen(val route: String) {
    data object Food : DetailsScreen(route = "food")

}













