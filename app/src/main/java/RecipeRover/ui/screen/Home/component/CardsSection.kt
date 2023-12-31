package RecipeRover.ui.screen.Home.component
import RecipeRover.data.local.Recipe
import RecipeRover.ui.RecipeViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fahad.RecipeRover.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import RecipeRover.ui.theme.dimens

@Composable
fun CardsSection(
  recipeViewModel: RecipeViewModel,
  navController: NavController
) {
  val recipesForTimeOfDay by rememberUpdatedState(newValue = recipeViewModel.getRecipesByTimeOfDay())


  Column {
    Text(
     text = recipeViewModel.getGreetingText(),
      modifier = Modifier
        .fillMaxWidth()
        .padding(dimens.small3),
      fontSize = MaterialTheme.typography.titleMedium.fontSize,
      fontWeight = FontWeight.Bold,
      fontStyle = Italic,

      color = MaterialTheme.colorScheme.primary
    )

    LazyRow {
      items(recipesForTimeOfDay) { recipe ->
        CardItem(recipe = recipe, navController = navController)
      }
    }
  }
}

@Composable
fun CardItem(
  recipe: Recipe,
  navController: NavController
) {

  Box(
    modifier = Modifier .padding(start = dimens.small2, end = dimens.small1).clickable(onClick = {
      navController.navigate("itemDetails/${recipe.title}")

    }
    )
      .clip(RoundedCornerShape(25.dp))
      .background(
        color = colorResource(id = R.color.black).copy(alpha = 0.7f)
      )
      .width(dimens.widthImage)
      .height(dimens.heightImage),
    contentAlignment = Alignment.BottomCenter

  ) {
    Image(
      painter = painterResource(id = recipe.imageResId),
      contentDescription = recipe.title,
      modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(25.dp)),
      contentScale = ContentScale.Crop
    )

    Box(
      modifier = Modifier.padding(dimens.small1)


        .background(
          Brush.verticalGradient(
            colors = listOf(
              Color.Transparent,
              Color.Black.copy(alpha = 0.5f),
              Color.Black.copy(alpha = 0.7f),
              Color.Black.copy(alpha = 0.9f),
              Color.Black
            ),
            startY = 0f,
            endY = 50f
          )
        ),


      ) {

      Text(
        text = recipe.title,
        color = Color.White,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
        textAlign = TextAlign.Center,

        )

    }

  }
}
