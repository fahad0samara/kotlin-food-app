package RecipeRover.ui.screen.Home.component

import androidx.compose.material3.OutlinedTextField

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.CutCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

import com.fahad.RecipeRover.ui.navigation.bottom.SearchNavGraph

import com.fahad.RecipeRover.ui.theme.dimens

@Composable
fun SearchHome(
    navController: NavController
){
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


    placeholder = { Text("Search for recipes") }
  )

}