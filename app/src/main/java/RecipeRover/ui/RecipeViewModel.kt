package RecipeRover.ui

import RecipeRover.data.local.FoodType
import RecipeRover.data.local.Recipe
import RecipeRover.data.local.availableRecipes
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipeViewModel
constructor() : ViewModel() {


  // Use StateFlow to observe changes in the recipes
  private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
  val recipes: StateFlow<List<Recipe>> get() = _recipes

  // Sample data initialization
  init {
    // Add your logic to fetch recipes from a data source (e.g., API, database)
    _recipes.value = availableRecipes
  }

  // Add methods to fetch individual recipes, related recipes, etc.

  fun getRecipeById(recipeId: Int): Recipe? {
    // Add your logic to fetch a recipe based on the provided recipeId
    return _recipes.value.find { it.title == recipeId.toString() }
  }

  fun getRelatedRecipes(foodType: FoodType): List<Recipe> {
    // Add your logic to fetch related recipes based on the provided foodType
    return _recipes.value.filter { it.foodType == foodType }
  }

}



