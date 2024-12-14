package RecipeRover.ui.navigation.bottom

import RecipeRover.ui.RecipeViewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fahad.RecipeRover.ui.screen.favorite.FavoriteViewModel

import RecipeRover.ui.screen.Home.Home
import RecipeRover.ui.screen.Home.details.ItemDetailsScreen

import RecipeRover.ui.screen.UserDataViewModel
import RecipeRover.ui.screen.auth.profile.EditProfileScreen
import RecipeRover.ui.screen.auth.profile.ProfileScreen


import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.fahad.RecipeRover.ui.navigation.bottom.BottomBar
import RecipeRover.ui.screen.Home.search.SearchScreen
import com.fahad.RecipeRover.ui.screen.favorite.FavoriteItemsScreen

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BottomBarNavigation(
  navController: NavHostController,
) {
  val userDataViewModel: UserDataViewModel = hiltViewModel()

  val favoriteViewModel: FavoriteViewModel = hiltViewModel()
  val recipeViewModel: RecipeViewModel = hiltViewModel()
  LaunchedEffect(userDataViewModel.user) {
    userDataViewModel.getUserData() // Trigger fetching user data if not already done

  }




  NavHost(
    navController = navController, route = "root", startDestination = BottomBar.Home.route
  ) {
    composable(route = BottomBar.Home.route) {
      Home(
        recipeViewModel, navController, userDataViewModel
      )
    }



    composable(route = BottomBar.Favorite.route) {
      FavoriteItemsScreen(favoriteViewModel, navController)

    }


    composable(route = BottomBar.Profile.route) {
      ProfileScreen(
        navController = navController, userDataViewModel = userDataViewModel
      )
    }
    composable(route = "edit_profile") {
      EditProfileScreen(
        navController = navController, userDataViewModel = userDataViewModel
      )
    }
    composable(
      "itemDetails/{itemName}",
      arguments = listOf(navArgument("itemName") { type = NavType.StringType })
    ) { backStackEntry ->
      val itemName = backStackEntry.arguments?.getString("itemName")
      val selectedItem = recipeViewModel.recipes.value.find { it.title == itemName }
      selectedItem?.let { item ->
        ItemDetailsScreen(item, favoriteViewModel, navController, recipeViewModel)
      } ?: run {
        Text(text = "Item not found")
      }
    }



    searchNavGraph(navController = navController)

  }
}

fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {

  navigation(
    startDestination = "search",
    route = "search_nav_graph",

    ) {
    composable(route = "search") {
      SearchScreen(navController = navController, viewModel = hiltViewModel())

    }

  }
}




