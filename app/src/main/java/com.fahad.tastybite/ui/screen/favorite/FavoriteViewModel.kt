package com.fahad.tastybite.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.fahad.tastybite.data.local.entities.FavoriteItem

import com.fahad.list_food.data.local.repository.FavoriteRepository
import com.fahad.tastybite.data.local.FoodItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import javax.inject.Inject
@HiltViewModel
class FavoriteViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository):ViewModel(){
    val favorite: Flow<List<FavoriteItem>> = favoriteRepository.getAllFavorite()



    fun addToFavorite(item: FoodItem) {
        val newItem = FavoriteItem(
            title = item.name,
            description = item.description,
            imageResId = item.imageResId,
            price = item.price
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