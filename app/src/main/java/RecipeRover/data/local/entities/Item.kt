package com.fahad.RecipeRover.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val imageResId: Int,
    val servings: Int,
    var quantity: Int = 1,

)





