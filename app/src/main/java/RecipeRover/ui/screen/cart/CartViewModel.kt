package RecipeRover.ui.screen.cart

import RecipeRover.data.local.Recipe
import RecipeRover.data.local.availableRecipes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.fahad.RecipeRover.data.local.entities.Item
import com.fahad.list_food.data.local.repository.ItemRepository



import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(private val itemRepository: ItemRepository):ViewModel() {
    val cart: Flow<List<Item>> = itemRepository.getAllItems()


    val groupedItems = availableRecipes.groupBy { it.title }

    fun addToCart(item: Recipe) {
        viewModelScope.launch {
            val newItem = Item(
                title = item.title,
                description = item.description,
                imageResId = item.imageResId,
                servings = item.servings,




            )
            itemRepository.insertItem(newItem)
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            itemRepository.deleteItem(item)
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            itemRepository.deleteAllItems()
        }
    }

    fun incrementItem(item: Item) {
        viewModelScope.launch {
            itemRepository.incrementItemQuantity(item.id)
        }
    }

    fun decrementItem(item: Item) {
          viewModelScope.launch {
                itemRepository.decrementItemQuantity(item.id)
            }
        }









}









