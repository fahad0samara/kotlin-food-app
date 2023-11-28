package com.fahad.RecipeRover.ui.screen.favorite

import RecipeRover.data.local.Recipe
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import RecipeRover.data.local.entities.FavoriteItem

import com.fahad.list_food.data.local.repository.FavoriteRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import javax.inject.Inject
@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository):ViewModel(){
    val favorite: Flow<List<FavoriteItem>> = favoriteRepository.getAllFavorite()



    fun addToFavorite(item: Recipe) {
        val newItem = FavoriteItem(
            title = item.title,
            description = item.description,
            imageResId = item.imageResId,
            servings = item.servings,
        )
         viewModelScope.launch {
                favoriteRepository.insertFavorite(newItem)
         }
    }


    fun isBookInFavorites(bookTitle: String): Flow<Boolean> {
        return favoriteRepository.isBookInFavorites(bookTitle)
    }


     fun deleteFromFavorites(favoriteItem: FavoriteItem) {
        viewModelScope.launch {
            favoriteRepository.deleteFavorite(favoriteItem)
        }

    }

}