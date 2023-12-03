package RecipeRover.ui.screen.Home

import RecipeRover.data.local.Recipe
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import RecipeRover.data.local.entities.FavoriteItem
import RecipeRover.ui.RecipeViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.ui.text.style.TextOverflow
import com.fahad.RecipeRover.ui.screen.favorite.FavoriteViewModel
import com.fahad.RecipeRover.ui.theme.dimens

@Composable
fun ItemDetailsScreen(
  item: Recipe,
  favoriteViewModel: FavoriteViewModel,
  navController: NavController,
  recipeViewModel: RecipeViewModel
) {

  val relatedItems = recipeViewModel.getRelatedRecipes(item.foodType)

  val isBookInFavorites by favoriteViewModel.isBookInFavorites(item.title).collectAsState(false)

  Box(
    modifier = Modifier.fillMaxSize()

  ) {

    LazyColumn(
      state = rememberLazyListState(),

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
            .background(MaterialTheme.colorScheme.surface)
        ) {
          // Circular image
          Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = null,
            modifier = Modifier
              .fillMaxSize()
              .clip(RoundedCornerShape(16.dp))
              .background(MaterialTheme.colorScheme.surface)
              .aspectRatio(1f),

            contentScale = ContentScale.Crop
          )

          // Back button
          IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
              .align(Alignment.TopStart)
              .padding(16.dp)
              .background(MaterialTheme.colorScheme.onBackground, CircleShape)
              .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
          ) {
            Icon(
              Icons.Default.ArrowBack,
              contentDescription = "Back",
              modifier = Modifier.size(32.dp),
              tint = MaterialTheme.colorScheme.background
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
          Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            // Favorite button fixed on the left
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
              }, modifier = Modifier

                .padding(16.dp)
                .background(
                  Color(0xFFE0E0E0), CircleShape
                )
                .size(50.dp)
            ) {
              Icon(
                Icons.Default.Favorite,
                contentDescription = "Favorite",
                modifier = Modifier.size(32.dp),
                tint = if (isBookInFavorites) Color.Red else Color.Black
              )
            }
            Text(
              text = item.title,
              fontSize = MaterialTheme.typography.headlineMedium.fontSize,
              fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Center,
              color = MaterialTheme.colorScheme.onSurface,
            )

          }

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
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Servings: ${item.servings}",
              fontSize = 16.sp,
              fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface
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
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Time: ${item.cookingTime} min",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSurface
            )
          }

          // Recipe Ingredients
          Text(
            text = "Ingredients:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 16.dp)
          )
          item.ingredients.forEach { ingredient ->
            Text(
              text = "- ${ingredient.name}",
              fontSize = 16.sp,
              color = MaterialTheme.colorScheme.onSurface,
              modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
            )
          }

          // Recipe Steps
          Text(
            text = "Steps:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 16.dp)
          )
          item.steps.forEach { step ->
            Text(
              text = "${step.order}. ${step.description}",
              fontSize = 16.sp,
              color = MaterialTheme.colorScheme.onSurface,
              modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
            )
          }
        }
      }

      // Related items section
      if (relatedItems.isNotEmpty()) {
        item {
          Text(
            text = "you may also like",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = dimens.small2)
          )

          LazyRow(
            contentPadding = PaddingValues(start = 10.dp, top = 8.dp, end = 16.dp, bottom = 10.dp)
          ) {
            items(relatedItems) { relatedItem ->
              RelatedItemCard(relatedItem = relatedItem, navController = navController)

            }
          }
        }
      }
    }
  }
}

@Composable
fun RelatedItemCard(relatedItem: Recipe, navController: NavController) {
  Box(
    modifier = Modifier
      .width(dimens.imageSize)
      .padding(end = 8.dp)
  ) {
    Card(
      shape = RoundedCornerShape(16.dp),
      modifier = Modifier
        .fillMaxSize()
        .clickable {
          /* Navigate to related item details */
          navController.navigate("itemDetails/${relatedItem.title}")
        },

      ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(dimens.small2),
      ) {
        Image(
          painter = painterResource(id = relatedItem.imageResId),
          contentDescription = null,
          modifier = Modifier
            .fillMaxWidth()
            .height(dimens.heightImage)
            .clip(
              RoundedCornerShape(16.dp)
            ), // Clip to CircleShape for a circular image
          contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = relatedItem.title,
          fontSize = MaterialTheme.typography.bodyLarge.fontSize,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }
    }
  }
}









