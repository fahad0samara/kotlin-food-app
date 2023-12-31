package RecipeRover.data.local

import com.fahad.RecipeRover.R
enum class FoodType {
  Appetizer, MainCourse, Dessert, Snack, Beverage,Breakfast, Lunch, Dinner, Other
}
enum class IngredientType {
  Vegetable, Meat, Dairy, Fruit, Grain, Spice, Seafood, Dessert, Beverage, Protein,
  Other

}
enum class MealTime {
  Morning, Evening, Night
}

data class Ingredient(
  val name: String,
  val type: IngredientType
)

data class RecipeStep(
  val order: Int,
  val description: String
)

data class Recipe(
  val title: String,
  val chef: String,
  val description: String,
  val imageResId: Int,
  val ingredients: List<Ingredient>,
  val steps: List<RecipeStep>,
  val servings: Int,
  val preparationTime: Int, // in minutes
  val cookingTime: Int, // in minutes
  val difficultyLevel: String // Easy, Medium, Hard,
    , val foodType: FoodType = FoodType.Other,
    val mealTime: MealTime = MealTime.Night



)


val availableRecipes = listOf(
  Recipe(
    "Morning Smoothie",
    "Chef Morning",
    "A refreshing smoothie to start your day.",
    R.drawable.morning_smoothie,
    listOf(
      Ingredient("Banana", IngredientType.Fruit),
      Ingredient("Strawberries", IngredientType.Fruit),
      Ingredient("Yogurt", IngredientType.Dairy)
    ),
    listOf(
      RecipeStep(1, "Peel and slice the banana."),
      RecipeStep(2, "Wash and hull the strawberries."),
      RecipeStep(3, "Blend the fruits with yogurt until smooth."),
      RecipeStep(4, "Pour into a glass and enjoy your morning!")
    ),
    1,
    5,
    10,
    "Easy",
    FoodType.Breakfast,
    MealTime.Morning
  ),
  Recipe(
    "Evening Salad",
    "Chef Evening",
    "A light and tasty salad for the evening.",
    R.drawable.evening_salad,
    listOf(
      Ingredient("Lettuce", IngredientType.Vegetable),
      Ingredient("Tomato", IngredientType.Vegetable),
      Ingredient("Cucumber", IngredientType.Vegetable),
      Ingredient("Feta Cheese", IngredientType.Dairy)
    ),
    listOf(
      RecipeStep(1, "Chop the lettuce, tomato, and cucumber."),
      RecipeStep(2, "Crumble the feta cheese on top."),
      RecipeStep(3, "Drizzle with your favorite dressing."),
      RecipeStep(4, "Toss and enjoy your evening salad!")
    ),
    2,
    10,
    0,
    "Easy",
    FoodType.Dinner,
    MealTime.Evening
  ),
  Recipe(
    "Night Soup",
    "Chef Night",
    "A hearty soup for a cozy night.",
    R.drawable.night_soup,
    listOf(
      Ingredient("Carrot", IngredientType.Vegetable),
      Ingredient("Potato", IngredientType.Vegetable),
      Ingredient("Chicken Broth", IngredientType.Meat)
    ),
    listOf(
      RecipeStep(1, "Peel and chop the carrot and potato."),
      RecipeStep(2, "Bring the chicken broth to a boil."),
      RecipeStep(3, "Add the chopped vegetables to the broth."),
      RecipeStep(4, "Simmer until vegetables are tender."),
      RecipeStep(5, "Serve and enjoy your night soup!")
    ),
    4,
    15,
    25,
    "Medium",
    FoodType.Dinner,
    MealTime.Night
  ),
  Recipe(
    "Afternoon Snack",
    "Chef Snack",
    "A quick and delicious snack for the afternoon.",
    R.drawable.afternoon_snack,
    listOf(
      Ingredient("Cheese", IngredientType.Dairy),
      Ingredient("Grapes", IngredientType.Fruit),
      Ingredient("Crackers", IngredientType.Grain)
    ),
    listOf(
      RecipeStep(1, "Arrange cheese, grapes, and crackers on a plate."),
      RecipeStep(2, "Enjoy your tasty afternoon snack!")
    ),
    2,
    5,
    0,
    "Easy",
    FoodType.Snack,
    MealTime.Evening
  ),
  Recipe(
    "Weekend Brunch",
    "Chef Brunch",
    "A leisurely brunch for the weekend.",
    R.drawable.weekend_brunch,
    listOf(
      Ingredient("Eggs", IngredientType.Protein),
      Ingredient("Avocado", IngredientType.Vegetable),
      Ingredient("Bread", IngredientType.Grain)
    ),
    listOf(
      RecipeStep(1, "Poach or fry the eggs."),
      RecipeStep(2, "Slice the avocado."),
      RecipeStep(3, "Toast the bread."),
      RecipeStep(4, "Assemble eggs, avocado, and toast on a plate."),
      RecipeStep(5, "Enjoy your delightful weekend brunch!")
    ),
    4,
    20,
    15,
    "Medium",
    FoodType.Breakfast,
    MealTime.Morning
  ),
  Recipe(
    "Late Night Snack",
    "Chef Late Night",
    "A satisfying late-night snack for your cravings.",
    R.drawable.late_night_snack,
    listOf(
      Ingredient("Popcorn", IngredientType.Grain),
      Ingredient("Chocolate", IngredientType.Dessert),
      Ingredient("Nuts", IngredientType.Protein)
    ),
    listOf(
      RecipeStep(1, "Pop the popcorn."),
      RecipeStep(2, "Melt chocolate."),
      RecipeStep(3, "Mix popcorn, melted chocolate, and nuts."),
      RecipeStep(4, "Enjoy your delicious late-night snack!")
    ),
    2,
    10,
    5,
    "Easy",
    FoodType.Snack,
    MealTime.Night
  ),

  Recipe(
    "Mango Tango Smoothie",
    "Chef Aria",
    "A tropical blend of mango, pineapple, and banana for a refreshing smoothie.",
    R.drawable.mango_tango_smoothie,
    listOf(
      Ingredient("Mango", IngredientType.Fruit),
      Ingredient("Pineapple", IngredientType.Fruit),
      Ingredient("Banana", IngredientType.Fruit),
      Ingredient("Yogurt", IngredientType.Dairy)
    ),
    listOf(
      RecipeStep(1, "Peel and chop the mango, pineapple, and banana."),
      RecipeStep(2, "Blend the fruits with yogurt until smooth."),
      RecipeStep(3, "Pour into a glass and enjoy."),
      RecipeStep(4, "Garnish with a slice of mango."),
      RecipeStep(5, "Optional: Add ice cubes for extra chill."),
      RecipeStep(6, "Serve and enjoy the tropical goodness!")
    ),
    1,
    5,
    10,
    "Easy",
    FoodType.Beverage,
    MealTime.Morning
  ),
  Recipe(
    "Vegetarian Stir-Fry",
    "Chef Noah",
    "Colorful and nutritious stir-fry with a mix of vegetables and tofu.",
    R.drawable.vegetarian_stir_fry,
    listOf(
      Ingredient("Tofu", IngredientType.Protein),
      Ingredient("Broccoli", IngredientType.Vegetable),
      Ingredient("Bell Peppers", IngredientType.Vegetable),
      Ingredient("Soy Sauce", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Press and dice the tofu."),
      RecipeStep(2, "Stir-fry tofu and vegetables in a hot pan."),
      RecipeStep(3, "Add soy sauce for flavor.")
    ),
    4,
    15,
    20,
    "Medium",
    FoodType.MainCourse,
    MealTime.Evening
  ),
  Recipe(
    "Vegetarian Stir-Fry",
    "Chef Noah",
    "Colorful and nutritious stir-fry with a mix of vegetables and tofu.",
    R.drawable.vegetarian_stir_fry,
    listOf(
      Ingredient("Tofu", IngredientType.Protein),
      Ingredient("Broccoli", IngredientType.Vegetable),
      Ingredient("Bell Peppers", IngredientType.Vegetable),
      Ingredient("Soy Sauce", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Press and dice the tofu."),
      RecipeStep(2, "Stir-fry tofu and vegetables in a hot pan."),
      RecipeStep(3, "Add soy sauce for flavor."),
      RecipeStep(4, "Continue stir-frying until vegetables are tender."),
      RecipeStep(5, "Adjust seasoning according to taste."),
      RecipeStep(6, "Serve hot and enjoy!")
    ),
    4,
    15,
    20,
    "Medium",
    FoodType.MainCourse,
    MealTime.Evening
  ),
  Recipe(
    "Berry Parfait",
    "Chef Lily",
    "Layers of yogurt, granola, and mixed berries for a delightful parfait.",
    R.drawable.berry_parfait,
    listOf(
      Ingredient("Mixed Berries", IngredientType.Fruit),
      Ingredient("Yogurt", IngredientType.Dairy),
      Ingredient("Granola", IngredientType.Grain),
      Ingredient("Honey", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Layer yogurt, granola, and berries in a glass."),
      RecipeStep(2, "Repeat until the glass is full."),
      RecipeStep(3, "Drizzle honey on top."),
      RecipeStep(4, "Add another layer of granola."),
      RecipeStep(5, "Top with more berries."),
      RecipeStep(6, "Finish with a dollop of yogurt.")
    ),
    2,
    10,
    15,
    "Easy",
    FoodType.Dessert,
    MealTime.Morning
  ),
  Recipe(
    "Teriyaki Salmon",
    "Chef Levi",
    "Grilled salmon fillets glazed with a flavorful teriyaki sauce.",
    R.drawable.teriyaki_salmon,
    listOf(
      Ingredient("Salmon Fillets", IngredientType.Seafood),
      Ingredient("Teriyaki Sauce", IngredientType.Other),
      Ingredient("Garlic", IngredientType.Other),
      Ingredient("Ginger", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Marinate salmon in teriyaki sauce, garlic, and ginger."),
      RecipeStep(2, "Preheat the grill to medium-high heat."),
      RecipeStep(3, "Grill the salmon for 5-7 minutes per side, basting with teriyaki sauce."),
      RecipeStep(4, "Check for doneness; the salmon should flake easily with a fork."),
      RecipeStep(5, "Remove from the grill and let it rest for a few minutes."),
      RecipeStep(6, "Serve the teriyaki salmon with steamed rice and your favorite vegetables.")
    ),
    4,
    15,
    20,
    "Medium",
    FoodType.MainCourse,
    MealTime.Evening
  ),

  Recipe(
    "Apple Cinnamon Pancakes",
    "Chef Mia",
    "Fluffy pancakes with diced apples and a sprinkle of cinnamon.",
    R.drawable.apple_cinnamon_pancakes,
    listOf(
      Ingredient("Pancake Mix", IngredientType.Grain),
      Ingredient("Apple", IngredientType.Fruit),
      Ingredient("Cinnamon", IngredientType.Spice),
      Ingredient("Maple Syrup", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Prepare pancake batter according to the mix."),
      RecipeStep(2, "Fold in diced apples and a pinch of cinnamon."),
      RecipeStep(3, "Cook pancakes on a griddle and serve with maple syrup."),
      RecipeStep(4, "Prepare pancake batter according to the mix."),
      RecipeStep(5, "Cook pancakes on a griddle and serve with maple syrup."),
      RecipeStep(6, "Enjoy your delicious Apple Cinnamon Pancakes!")
    ),
    4,
    15,
    25,
    "Medium",
    FoodType.Breakfast,
    MealTime.Morning
  ),
  Recipe(
    "Vegetable Curry",
    "Chef Owen",
    "Hearty vegetable curry with a rich blend of spices and coconut milk.",
    R.drawable.vegetable_curry,
    listOf(
      Ingredient("Mixed Vegetables", IngredientType.Vegetable),
      Ingredient("Curry Powder", IngredientType.Spice),
      Ingredient("Coconut Milk", IngredientType.Dairy),
      Ingredient("Basmati Rice", IngredientType.Grain)
    ),
    listOf(
      RecipeStep(1, "Sauté vegetables in curry powder."),
      RecipeStep(2, "Add coconut milk and simmer until vegetables are tender."),
      RecipeStep(3, "Serve over cooked basmati rice."),
      RecipeStep(4, "Garnish with cilantro for added freshness."),
      RecipeStep(5, "Sprinkle with a pinch of garam masala for extra flavor."),
      RecipeStep(6, "Enjoy your delicious vegetable curry!")
    ),
    4,
    20,
    30,
    "Medium",
    FoodType.MainCourse,
    MealTime.Evening
  ),

  Recipe(
    "Margherita Pizza",
    "Chef Mario",
    "Classic pizza topped with fresh tomatoes, mozzarella, and basil. A timeless favorite!",
    R.drawable.pizza_margherita,
    listOf(
      Ingredient("Pizza Dough", IngredientType.Grain),
      Ingredient("Tomatoes", IngredientType.Vegetable),
      Ingredient("Mozzarella Cheese", IngredientType.Dairy),
      Ingredient("Basil", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Preheat the oven to 475°F."),
      RecipeStep(2, "Roll out the pizza dough."),
      RecipeStep(3, "Top the dough with tomatoes, mozzarella, and basil."),
      RecipeStep(4, "Bake in the oven for 12-15 minutes or until the crust is golden."),
      RecipeStep(5, "Remove from the oven and let it cool for a few minutes."),
      RecipeStep(6, "Slice and enjoy your delicious Margherita Pizza!")
    ),
    1,
    15,
    15,
    "Medium",
    FoodType.MainCourse,
    MealTime.Night
  ),

  Recipe(
    "Chicken Alfredo Pasta",
    "Chef Carla",
    "Creamy Alfredo sauce with grilled chicken served over perfectly cooked pasta.",
    R.drawable.chicken_alfredo_pasta,
    listOf(
      Ingredient("Fettuccine Pasta", IngredientType.Grain),
      Ingredient("Chicken Breast", IngredientType.Meat),
      Ingredient("Heavy Cream", IngredientType.Dairy),
      Ingredient("Parmesan Cheese", IngredientType.Dairy)
    ),
    listOf(
      RecipeStep(1, "Cook the pasta according to package instructions."),
      RecipeStep(2, "Grill the chicken breast until fully cooked."),
      RecipeStep(3, "Prepare the Alfredo sauce by simmering heavy cream and Parmesan."),
      RecipeStep(4, "Combine cooked pasta, grilled chicken, and Alfredo sauce."),
      RecipeStep(5, "Let the mixture simmer for 5 minutes."),
      RecipeStep(6, "Serve hot and enjoy!")
    ),
    4,
    20,
    25,
    "Medium",
    FoodType.MainCourse,
    MealTime.Night
  ),
  Recipe(
    "Chocolate Brownie Sundae",
    "Chef Emily",
    "Warm chocolate brownie topped with vanilla ice cream, chocolate sauce, and whipped cream.",
    R.drawable.chocolate_brownie_sundae,
    listOf(
      Ingredient("Chocolate Brownie", IngredientType.Dessert),
      Ingredient("Vanilla Ice Cream", IngredientType.Dairy),
      Ingredient("Chocolate Sauce", IngredientType.Other),
      Ingredient("Whipped Cream", IngredientType.Dairy)
    ),
    listOf(
      RecipeStep(1, "Bake the chocolate brownie according to the recipe."),
      RecipeStep(2, "Scoop vanilla ice cream on top of the warm brownie."),
      RecipeStep(3, "Drizzle chocolate sauce and add a dollop of whipped cream."),
      RecipeStep(4, "Wait for a moment to let the ice cream slightly melt."),
      RecipeStep(5, "Use a fork to break into the warm brownie, mixing it with the melted ice cream."),
      RecipeStep(6, "Enjoy the delightful combination of warm brownie, cold ice cream, and rich toppings.")
    ),
    2,
    15,
    20,
    "Easy",
    FoodType.Dessert,
    MealTime.Night
  ),

  Recipe(
    "Spicy Chicken Wings",
    "Chef Alex",
    "Crispy and spicy chicken wings, perfect for sharing with friends.",
    R.drawable.spicy_chicken_wings,
    listOf(
      Ingredient("Chicken Wings", IngredientType.Meat),
      Ingredient("Spices", IngredientType.Spice),
      Ingredient("Flour", IngredientType.Grain),
      Ingredient("Oil", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Coat chicken wings with a mixture of spices and flour."),
      RecipeStep(2, "Fry the wings in hot oil until golden and crispy."),
      RecipeStep(3, "Toss the wings in more spice mix before serving."),
      RecipeStep(4, "Place the wings on a serving platter."),
      RecipeStep(5, "Garnish with fresh cilantro or parsley."),
      RecipeStep(6, "Serve with your favorite dipping sauce.")
    ),
    4,
    10,
    20,
    "Medium",
    FoodType.Appetizer,
    MealTime.Evening
  ),

  Recipe(
    "Iced Caramel Latte",
    "Chef Olivia",
    "Refreshing iced latte with caramel flavor, a delightful pick-me-up.",
    R.drawable.iced_caramel_latte,
    listOf(
      Ingredient("Espresso", IngredientType.Beverage),
      Ingredient("Milk", IngredientType.Dairy),
      Ingredient("Caramel Syrup", IngredientType.Other),
      Ingredient("Ice", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Brew a strong cup of espresso."),
      RecipeStep(2, "Combine espresso, milk, and caramel syrup."),
      RecipeStep(3, "Pour the mixture over ice and stir well."),
      RecipeStep(4, "Add a drizzle of caramel on top for extra sweetness."),
      RecipeStep(5, "Garnish with whipped cream if desired."),
      RecipeStep(6, "Enjoy your delicious iced caramel latte!")
    ),
    1,
    5,
    5,
    "Easy",
    FoodType.Beverage,
    MealTime.Morning
  ),

  Recipe(
    "Guacamole and Chips",
    "Chef Diego",
    "Freshly made guacamole served with crispy tortilla chips.",
    R.drawable.guacamole_and_chips,
    listOf(
      Ingredient("Avocado", IngredientType.Fruit),
      Ingredient("Tomato", IngredientType.Vegetable),
      Ingredient("Onion", IngredientType.Vegetable),
      Ingredient("Lime", IngredientType.Fruit)
    ),
    listOf(
      RecipeStep(1, "Mash avocados in a bowl."),
      RecipeStep(2, "Add diced tomatoes, onions, and lime juice."),
      RecipeStep(3, "Season with salt and pepper."),
      RecipeStep(4, "Mix well until all ingredients are combined."),
      RecipeStep(5, "Chill in the refrigerator for 30 minutes."),
      RecipeStep(6, "Serve with crispy tortilla chips.")
    ),
    4,
    10,
    15,
    "Easy",
    FoodType.Appetizer,
    MealTime.Evening
    ),

  Recipe(
    "Fruit Salad",
    "Chef Sofia",
    "A healthy and delicious mix of seasonal fruits, a perfect light option.",
    R.drawable.fruit_salad,
    listOf(
      Ingredient("Strawberries", IngredientType.Fruit),
      Ingredient("Blueberries", IngredientType.Fruit),
      Ingredient("Grapes", IngredientType.Fruit),
      Ingredient("Kiwi", IngredientType.Fruit)
    ),
    listOf(
      RecipeStep(1, "Wash and chop the fruits."),
      RecipeStep(2, "Combine the fruits in a large bowl."),
      RecipeStep(3, "Chill in the refrigerator before serving."),
      RecipeStep(4, "Enjoy your refreshing fruit salad!"),
      RecipeStep(5, "Share with friends and family."),
      RecipeStep(6, "Experiment with different fruit combinations.")
    ),
    4,
    10,
    10,
    "Easy",
    FoodType.Snack,
    MealTime.Night
  ),

  Recipe(
    "Cheese Platter",
    "Chef Ethan",
    "An assortment of fine cheeses served with crackers and fruits.",
    R.drawable.cheese_platter,
    listOf(
      Ingredient("Brie Cheese", IngredientType.Dairy),
      Ingredient("Cheddar Cheese", IngredientType.Dairy),
      Ingredient("Gouda Cheese", IngredientType.Dairy),
      Ingredient("Crackers", IngredientType.Grain)
    ),
    listOf(
      RecipeStep(1, "Arrange a variety of cheeses on a platter."),
      RecipeStep(2, "Add crackers and sliced fruits as accompaniments."),
      RecipeStep(3, "Garnish with fresh herbs for added flavor."),
      RecipeStep(4, "Serve and enjoy!")
    ),
    4,
    15,
    15,
    "Easy",
    FoodType.Appetizer,
    MealTime.Evening
  ),
  Recipe(
    "Chocolate Chip Cookies",
    "Chef Ava",
    "Homemade chocolate chip cookies, a sweet treat for any occasion.",
    R.drawable.chocolate_chip_cookies,
    listOf(
      Ingredient("All-Purpose Flour", IngredientType.Grain),
      Ingredient("Butter", IngredientType.Dairy),
      Ingredient("Chocolate Chips", IngredientType.Other),
      Ingredient("Brown Sugar", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Preheat the oven to 350°F."),
      RecipeStep(2, "Cream together butter and brown sugar."),
      RecipeStep(3, "Mix in flour and chocolate chips."),
      RecipeStep(4, "Drop spoonfuls of dough onto a baking sheet. Bake for 10-12 minutes."),
      RecipeStep(5, "Allow cookies to cool on a wire rack."),
      RecipeStep(6, "Indulge in the deliciousness!")
    ),
    4,
    15,
    30,
    "Easy",
    FoodType.Dessert,
    MealTime.Night
  ),

// Additional Recipe with more RecipeSteps for each type
  Recipe(
    "Caesar Salad",
    "Chef Julia",
    "Crisp romaine lettuce, garlic croutons, and parmesan cheese tossed in Caesar dressing.",
    R.drawable.caesar_salad,
    listOf(
      Ingredient("Romaine Lettuce", IngredientType.Vegetable),
      Ingredient("Croutons", IngredientType.Grain),
      Ingredient("Parmesan Cheese", IngredientType.Dairy),
      Ingredient("Caesar Dressing", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Tear the lettuce into bite-sized pieces."),
      RecipeStep(2, "Add croutons and shaved Parmesan."),
      RecipeStep(3, "Drizzle Caesar dressing and toss before serving."),
      RecipeStep(4, "Garnish with additional Parmesan."),
      RecipeStep(5, "Optional: Add grilled chicken for extra protein."),
      RecipeStep(6, "Serve chilled and enjoy!")
    ),
    2,
    10,
    15,
    "Easy",
    FoodType.Appetizer,
    MealTime.Evening
  ),
  Recipe(
    "Shrimp Scampi",
    "Chef Antonio",
    "Tender shrimp sautéed in garlic and white sauce, served over linguine.",
    R.drawable.shrimp_scampi,
    listOf(
      Ingredient("Shrimp", IngredientType.Seafood),
      Ingredient("Linguine", IngredientType.Grain),
      Ingredient("Garlic", IngredientType.Other),
      Ingredient("White Wine", IngredientType.Beverage)
    ),
    listOf(
      RecipeStep(1, "Cook linguine according to package instructions."),
      RecipeStep(2, "Sauté shrimp in garlic and white wine."),
      RecipeStep(3, "Serve shrimp over cooked linguine."),
      RecipeStep(4, "Garnish with chopped parsley."),
      RecipeStep(5, "Add a squeeze of fresh lemon juice."),
      RecipeStep(6, "Sprinkle red pepper flakes for a hint of spice.")
    ),
    4,
    15,
    20,
    "Medium",
    FoodType.MainCourse,
    MealTime.Evening
  ),

  Recipe(
    "Blueberry Cheesecake",
    "Chef Isabella",
    "Creamy cheesecake with a blueberry swirl, topped with fresh blueberries.",
    R.drawable.blueberry_cheesecake,
    listOf(
      Ingredient("Cream Cheese", IngredientType.Dairy),
      Ingredient("Blueberries", IngredientType.Fruit),
      Ingredient("Graham Cracker Crust", IngredientType.Other),
      Ingredient("Sugar", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Preheat the oven to 325°F."),
      RecipeStep(2, "Mix cream cheese, sugar, and blueberries."),
      RecipeStep(3, "Pour mixture into a graham cracker crust and bake for 45 minutes."),
      RecipeStep(4, "Remove from the oven and let it cool."),
      RecipeStep(5, "Refrigerate for at least 4 hours or overnight."),
      RecipeStep(6, "Top with fresh blueberries before serving.")
    ),
    1,
    20,
    45,
    "Difficult",
    FoodType.Dessert,
    MealTime.Night
  ),

  Recipe(
    "Caprese Skewers",
    "Chef Giovanni",
    "Fresh mozzarella, cherry tomatoes, and basil drizzled with balsamic glaze.",
    R.drawable.caprese_skewers,
    listOf(
      Ingredient("Mozzarella Balls", IngredientType.Dairy),
      Ingredient("Cherry Tomatoes", IngredientType.Vegetable),
      Ingredient("Basil Leaves", IngredientType.Other),
      Ingredient("Balsamic Glaze", IngredientType.Other)
    ),
    listOf(
      RecipeStep(1, "Thread mozzarella, tomatoes, and basil onto skewers."),
      RecipeStep(2, "Drizzle with balsamic glaze before serving."),
      RecipeStep(3, "Serve chilled for a refreshing appetizer."),
      RecipeStep(4, "Garnish with additional basil leaves."),
      RecipeStep(5, "Enjoy the burst of flavors with each bite."),
      RecipeStep(6, "Perfect for any party or gathering!")
    ),
    4,
    10,
    15,
    "Easy",
    FoodType.Appetizer,
    MealTime.Evening
  ),

  Recipe(
    "Iced Green Tea",
    "Chef Jasmine",
    "A cool and soothing iced green tea, perfect for a refreshing break.",
    R.drawable.iced_green_tea,
    listOf(
      Ingredient("Green Tea Bags", IngredientType.Beverage),
      Ingredient("Water", IngredientType.Other),
      Ingredient("Honey", IngredientType.Other),
      Ingredient("Lemon Wedges", IngredientType.Fruit)
    ),
    listOf(
      RecipeStep(1, "Steep green tea bags in hot water."),
      RecipeStep(2, "Sweeten with honey and cool in the refrigerator."),
      RecipeStep(3, "Serve over ice with lemon wedges."),
      RecipeStep(4, "Garnish with mint leaves for extra freshness.")
    ),
    1,
    5,
    10,
    "Easy",
    FoodType.Beverage,
    MealTime.Morning
  )

  // Add more recipes...
)




