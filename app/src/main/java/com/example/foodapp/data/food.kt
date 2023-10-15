package com.example.foodapp.data

import androidx.annotation.DrawableRes
import com.example.foodapp.R

data class Food(
    val id: Int = 0,
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
    val type: FoodType,
    val liked: Boolean = false,
    val price: Int,
    val preparationTimeMinutes: Int,
    val rating: Float = 0.0f, // Added rating field
    val reviews: Int = 0 // Added reviews field
)

enum class FoodType {
    // 0 is the index of the first food type in the FoodType enum

    MainCourse, SideDish, Snack, Beverage, Dessert, Salad, Soup, Breakfast, Seafood, Vegetarian, Vegan
}


val foods = listOf(
    Food(
        id = 1,
        name = "Spaghetti Carbonara",
        description = "Delicious pasta with eggs, cheese, and pancetta",
        image = R.drawable.spaghetti_carbonara,
        type = FoodType.MainCourse,
        liked = false,
        price = 12, // Example price in your desired format
        preparationTimeMinutes = 30, // Example preparation time in minutes
        rating = 4.5f, // Example rating for this food
        reviews = 25 // Example number of reviews for this food
    ),
    Food(
        id = 2,
        name = "Caesar Salad",
        description = "Crispy romaine lettuce with Caesar dressing and croutons",
        image = R.drawable.caesar_salad,
        type = FoodType.SideDish,
        liked = false,
        price = 8, // Example price in your desired format
        preparationTimeMinutes = 15, // Example preparation time in minutes
        rating = 4.0f, // Example rating for this food
        reviews = 18 // Example number of reviews for this food
    ),
    Food(
        id = 3,
        name = "Chocolate Chip Cookies",
        description = "Homemade cookies with chocolate chips",
        image = R.drawable.chocolate_chip_cookies,
        type = FoodType.Snack,
        liked = false,
        price = 6, // Example price in your desired format
        preparationTimeMinutes = 20, // Example preparation time in minutes
        rating = 4.8f, // Example rating for this food
        reviews = 32 // Example number of reviews for this food
    ),
    Food(
        id = 4,
        name = "Cappuccino",
        description = "Classic Italian espresso coffee with frothy milk",
        image = R.drawable.capp_uccino,
        type = FoodType.Beverage,
        liked = false,
        price = 4, // Example price in your desired format
        preparationTimeMinutes = 5, // Example preparation time in minutes
        rating = 4.2f, // Example rating for this food
        reviews = 15 // Example number of reviews for this food
    ),    Food(
        id = 6,
        name = "Chicken Alfredo",
        description = "Creamy pasta with grilled chicken and Alfredo sauce",
        image = R.drawable.chicken_alfredo,
        type = FoodType.MainCourse,
        liked = false,
        price = 14, // Example price in your desired format
        preparationTimeMinutes = 35, // Example preparation time in minutes
        rating = 4.4f, // Example rating for this food
        reviews = 22 // Example number of reviews for this food
    ),
    Food(
        id = 7,
        name = "Greek Salad",
        description = "Fresh salad with feta cheese, olives, and Greek dressing",
        image = R.drawable.greek_salad,
        type = FoodType.SideDish,
        liked = false,
        price = 10, // Example price in your desired format
        preparationTimeMinutes = 15, // Example preparation time in minutes
        rating = 4.7f, // Example rating for this food
        reviews = 19 // Example number of reviews for this food
    ),
    Food(
        id = 8,
        name = "Blueberry Pancakes",
        description = "Fluffy pancakes with fresh blueberries and maple syrup",
        image = R.drawable.blueberry_pancakes,
        type = FoodType.Snack,
        liked = false,
        price = 7, // Example price in your desired format
        preparationTimeMinutes = 20, // Example preparation time in minutes
        rating = 4.9f, // Example rating for this food
        reviews = 36 // Example number of reviews for this food
    ),
    Food(
        id = 9,
        name = "Iced Tea",
        description = "Refreshing iced tea with a slice of lemon",
        image = R.drawable.iced_tea,
        type = FoodType.Beverage,
        liked = false,
        price = 3, // Example price in your desired format
        preparationTimeMinutes = 5, // Example preparation time in minutes
        rating = 4.1f, // Example rating for this food
        reviews = 14 // Example number of reviews for this food
    ),
    Food(
        id = 10,
        name = "Tiramisu",
        description = "Classic Italian dessert with coffee and mascarpone",
        image = R.drawable.tiramisu,
        type = FoodType.Dessert,
        liked = false,
        price = 8, // Example price in your desired format
        preparationTimeMinutes = 20, // Example preparation time in minutes
        rating = 4.6f, // Example rating for this food
        reviews = 40 // Example number of reviews for this food
    ),
    Food(
        id = 11,
        name = "Grilled Steak",
        description = "Juicy grilled steak with a side of vegetables",
        image = R.drawable.grilled_steak,
        type = FoodType.MainCourse,
        liked = false,
        price = 18, // Example price in your desired format
        preparationTimeMinutes = 25, // Example preparation time in minutes
        rating = 4.7f, // Example rating for this food
        reviews = 30 // Example number of reviews for this food
    ),
    Food(
        id = 12,
        name = "Vegetable Stir-Fry",
        description = "Colorful stir-fried vegetables with your choice of sauce",
        image = R.drawable.vegetable_stir_fry,
        type = FoodType.MainCourse,
        liked = false,
        price = 14, // Example price in your desired format
        preparationTimeMinutes = 20, // Example preparation time in minutes
        rating = 4.5f, // Example rating for this food
        reviews = 20 // Example number of reviews for this food
    ),

    )
