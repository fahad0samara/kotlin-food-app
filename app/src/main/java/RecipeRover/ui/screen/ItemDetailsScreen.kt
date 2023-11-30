package RecipeRover.ui.screen

import RecipeRover.data.local.Recipe
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import RecipeRover.data.local.entities.FavoriteItem
import RecipeRover.ui.screen.cart.CartViewModel
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape

import com.fahad.RecipeRover.ui.screen.favorite.FavoriteViewModel



@Composable
fun ItemDetailsScreen(
  item: Recipe,
  favoriteViewModel: FavoriteViewModel,
  navController: NavController
) {
  val isBookInFavorites by favoriteViewModel.isBookInFavorites(item.title).collectAsState(false)

  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
  ) {
    var scrollState = rememberLazyListState()

    LazyColumn(
      state = scrollState,
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
      item {
        // Header with circular image and back button
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(16.dp))
        ) {
          // Circular image
          Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = null,
            modifier = Modifier
              .fillMaxSize()
              .graphicsLayer(
                alpha = 0.5f,
                rotationZ = 30f,
                translationX = 100f,
                translationY = -100f
              )
              .clip(CircleShape)
              .background(MaterialTheme.colorScheme.surface)
              .align(Alignment.Center),
            contentScale = ContentScale.Crop
          )

          // Back button
          IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
              .align(Alignment.TopStart)
              .padding(16.dp)
              .background(MaterialTheme.colorScheme.surface, CircleShape)
          ) {
            Icon(
              Icons.Default.ArrowBack,
              contentDescription = "Back",
              modifier = Modifier.size(32.dp),
              tint = Color.Black
            )
          }
        }
      }

      item {
        // Recipe details
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
        ) {
          // Recipe title
          Text(
            text = item.title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface, // Text color
            modifier = Modifier
              .padding(top = 8.dp)
              .fillMaxWidth()
              .align(Alignment.CenterHorizontally)
          )

          // Recipe chef and details
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Chef: ${item.chef}",
              fontSize = 16.sp,
              fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface // Text color
            )
            Text(
              text = "Servings: ${item.servings}",
              fontSize = 16.sp,
              fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface // Text color
            )
          }

          // Recipe difficulty and time
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Difficulty: ${item.difficultyLevel}",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface // Text color
            )
            Text(
              text = "Time: ${item.cookingTime} min",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface // Text color
            )
          }

          // Recipe Ingredients
          Text(
            text = "Ingredients:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface, // Text color
            modifier = Modifier.padding(top = 16.dp)
          )
          item.ingredients.forEach { ingredient ->
            Text(
              text = "- ${ingredient.name}",
              fontSize = 16.sp,
              color = MaterialTheme.colorScheme.onSurface, // Text color
              modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
            )
          }

          // Recipe Steps
          Text(
            text = "Steps:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface, // Text color
            modifier = Modifier.padding(top = 16.dp)
          )
          item.steps.forEach { step ->
            Text(
              text = "${step.order}. ${step.description}",
              fontSize = 16.sp,
              color = MaterialTheme.colorScheme.onSurface, // Text color
              modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
            )
          }
        }
      }
    }

    // Favorite button fixed at the bottom
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .align(Alignment.BottomCenter)
    ) {
      IconButton(
        onClick = {
          if (isBookInFavorites) {
            favoriteViewModel.deleteFromFavorites(
              FavoriteItem(
                title = item.title,
                description = item.description,
                imageResId = item.imageResId,
                servings = item.servings
              )
            )
          } else {
            favoriteViewModel.addToFavorite(item)
          }
        },
        modifier = Modifier
          .size(50.dp)
          .background(MaterialTheme.colorScheme.primary, CircleShape)
      ) {
        Icon(
          Icons.Default.Favorite,
          contentDescription = "Favorite",
          modifier = Modifier.size(32.dp),
          tint = if (isBookInFavorites) Color.Red else Color.White
        )
      }
    }
  }
}






