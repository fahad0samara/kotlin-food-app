package com.fahad.RecipeRover.ui.screen

import RecipeRover.data.local.FoodType
import RecipeRover.data.local.Recipe
import RecipeRover.data.local.availableRecipes
import RecipeRover.ui.RecipeViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.fahad.RecipeRover.R


import com.fahad.RecipeRover.ui.navigation.bottom.SearchNavGraph
import RecipeRover.ui.screen.cart.CartViewModel
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.derivedStateOf
import com.fahad.RecipeRover.ui.theme.dimens

import java.time.LocalTime




@Composable
fun Home(
  recipeViewModel: RecipeViewModel,
  navController: NavController,
  userDataViewModel: UserDataViewModel
) {
  val selectedCategory = remember { mutableStateOf(FoodType.Appetizer) }



  // Filter recipes based on the selected category
  val itemsForCategory by remember(selectedCategory.value) {
    derivedStateOf {
      val category = selectedCategory.value.name
      recipeViewModel.recipes.value.filter { it.foodType.name == category }
    }
  }












  val user by userDataViewModel.user.collectAsState() // Observe the user state
  val painter = rememberAsyncImagePainter(
    ImageRequest.Builder(LocalContext.current).data(data =
    user?.photoUrl
    ).apply(block = fun ImageRequest.Builder.() {
      crossfade(true)
      transformations(CircleCropTransformation())
      scale(Scale.FILL)
    }).build()

    )

    val currentUser = user ?: return



  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.background)
      .padding(top = 15.dp)

      // Add padding for status bar
      .systemBarsPadding()
      .padding(bottom = 66.dp)



  ){
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(
          horizontal = 16.dp
        ),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      val greeting = when (LocalTime.now().hour) {
        in 0..11 -> "Good morning"
        in 12..17 -> "Good afternoon"
        else -> "Good evening"
      }

      Column {
        Text(
          text = "$greeting, ${currentUser.displayName}",
          fontSize = MaterialTheme.typography.headlineMedium.fontSize
        )
        Text(
          text = "Let's find you something to eat!",
          fontSize = MaterialTheme.typography.labelMedium.fontSize,
          fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary
        )
      }

      Spacer(modifier = Modifier.width(16.dp))

      // Display user's profile picture or a placeholder image if not available
      Image(
           painter = painter,
        contentDescription = null,
        modifier = Modifier
          .size(50.dp)
          .background(Color(0xFF91F1FF), CircleShape),
        contentScale = ContentScale.Crop
      )
    }

    Spacer(modifier = Modifier.height(16.dp))



    // Search bar with TextField

    OutlinedTextField(
      value = "",
      onValueChange = { },
      modifier = Modifier
        .fillMaxWidth()
        .padding(dimens.medium1)
        .height(dimens.logoSize1)
        .onFocusChanged {
          if (it.isFocused) {
            navController.navigate(
              SearchNavGraph.Search.route

            )
          }
        },


      trailingIcon = {
        Icon(
          Icons.Default.Search,
          modifier = Modifier
            .padding(dimens.small2)
            .size(dimens.medium2),

          contentDescription = null,
          tint = Color(0xFF91F1FF)
        )
      },
      colors = TextFieldDefaults.colors(

        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color(0xFF91F1FF),
        disabledContainerColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        disabledTextColor = Color.Transparent,
        disabledPlaceholderColor = Color.Transparent,
        disabledLeadingIconColor = Color.Transparent,
        disabledTrailingIconColor = Color.Transparent,


        ),
      shape = CutCornerShape(dimens.small3),


      placeholder = { Text("Search for books") }
    )

    CategorySelection(selectedCategory)

    FoodList(
        recipeViewModel,
        navController,
        itemsForCategory
        )

  }
}


@Composable
fun CategorySelection(selectedCategory: MutableState<FoodType>) {
  LazyRow(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 8.dp)
      .height(dimens.logoSize1),
    horizontalArrangement = Arrangement.spacedBy(2.dp),

    ) {
    items(FoodType.entries) { category ->
      Button(
        onClick = { selectedCategory.value = category },
        modifier = Modifier
          .padding(start = 5.dp, end = 10.dp),
        colors = ButtonDefaults.buttonColors(

          containerColor = if (selectedCategory.value == category) MaterialTheme.colorScheme.primary else Color.Transparent,
            disabledContainerColor = Color.Transparent,

        ),
      ) {
        Text(
          text = category.name,
          color = if (selectedCategory.value == category) Color.White else Color.Black
        )
      }
    }
  }
}
@Composable
fun FoodList(
  recipeViewModel: RecipeViewModel,
  navController: NavController,
  itemsForCategory: List<Recipe>
) {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(2.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(itemsForCategory) { item ->
        FoodItem(item, onTap = {
            navController.navigate("itemDetails/${item.title}")
        })
        }
    }

}








@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(
  food: Recipe,
  onTap: (Recipe) -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
    onClick = { onTap(food) },
    shape = CutCornerShape(8.dp),
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
    ) {
      // Background Image with Semi-Transparent Overlay
      Image(
        painter = painterResource(id = food.imageResId),
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .height(190.dp),
        contentScale = ContentScale.Crop
      )
      Box(
        modifier = Modifier
          .fillMaxSize()
      )

      // Text Content
      Box(
        modifier = Modifier
          .fillMaxSize()
          .align(Alignment.BottomStart)
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .background(
              color = colorResource(id = R.color.black).copy(alpha = 0.7f)
            ) // Semi-transparent background
        ) {
          Text(
            text = food.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
              .fillMaxWidth()
              .padding(8.dp),
            color = Color.White,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
          Spacer(modifier = Modifier.height(4.dp))

          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Text(
                text = "${food.servings} servings", // Assuming there's a 'servings' property in FoodItem
              fontSize = 14.sp,
              color = Color.White,
            )
            Text(
                  text = "${food.cookingTime} calories", // Assuming there's a 'calories' property in FoodItem
              fontSize = 14.sp,
              color = Color.White,
            )
          }
        }
      }
    }
  }
}













