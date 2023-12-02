package RecipeRover.ui

import RecipeRover.data.local.FoodType
import RecipeRover.data.local.MealTime
import RecipeRover.data.local.Recipe
import RecipeRover.data.local.availableRecipes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDateTime

class RecipeViewModel
constructor() : ViewModel() {


  // Use StateFlow to observe changes in the recipes
  private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
  val recipes: StateFlow<List<Recipe>> get() = _recipes

  // Sample data initialization
    init {
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


  fun getRecipesByTimeOfDay(): List<Recipe> {
    val currentHour = LocalDateTime.now().hour
    val mealTime = when (currentHour) {
      in 6..11 -> MealTime.Morning
      in 12..17 -> MealTime.Evening
      else -> MealTime.Night
    }

    return _recipes.value.filter { it.mealTime == mealTime }
  }


}



