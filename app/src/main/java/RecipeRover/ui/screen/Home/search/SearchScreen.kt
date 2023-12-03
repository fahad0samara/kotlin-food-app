package RecipeRover.ui.screen.Home.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.fahad.RecipeRover.R
import RecipeRover.ui.screen.cart.CartViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.systemBarsPadding
import RecipeRover.ui.theme.dimens

@Composable
fun SearchScreen(
  viewModel: CartViewModel,
  navController: NavController
) {
    var searchText by remember { mutableStateOf("") }
    val filteredBooks = viewModel.groupedItems.values.flatten().filter { book ->
        searchText.isEmpty() || book.title.contains(searchText, ignoreCase = true)
    }
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(top = dimens.medium1)

        // Add padding for status bar
        .systemBarsPadding()
        .padding(bottom = dimens.large)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimens.medium1),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Back button
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            // Search bar with TextField
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text(text = stringResource(id = R.string.search_food)) },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = dimens.medium1),
                trailingIcon = {
                    Icon(
                        Icons.Default.Search,
                        modifier = Modifier
                            .padding(dimens.small2)
                            .size(dimens.medium2),

                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                colors = TextFieldDefaults.colors(

                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                    disabledPlaceholderColor = Color.Transparent,
                    disabledLeadingIconColor = Color.Transparent,
                    disabledTrailingIconColor = Color.Transparent,
                ),
                shape = CutCornerShape(15.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search // Set the keyboard action to Search
                ),
            )
        }
        // Display search results in a LazyColumn when searchText is not empty
        if (searchText.isNotEmpty()) {
            if (filteredBooks.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(
                        items = filteredBooks,
                        itemContent = { food ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable {
                                        // Navigate to book details
                                        navController.navigate("itemDetails/${food.title}")
                                    },

                                ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = food.imageResId),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(dimens.heightImage)
                                    )
                                    Spacer(modifier = Modifier.width(dimens.medium1))
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(8.dp)
                                    ) {
                                        Text(
                                            text = food.title,
                                            style = MaterialTheme.typography.bodyMedium,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = food.chef,
                                            style = MaterialTheme.typography.bodyMedium,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                            }
                        }
                    )


                }
            } else {
                Text(
                    text = stringResource(id = R.string.no_results_found),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimens.medium1),
                )
            }
        }
    }
}







