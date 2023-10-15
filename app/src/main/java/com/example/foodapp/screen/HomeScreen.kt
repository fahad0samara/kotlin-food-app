package com.example.foodapp.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp.R
import com.example.foodapp.data.Food
import com.example.foodapp.data.FoodType
import com.example.foodapp.data.foods
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val onFoodItemClick: (Food) -> Unit = { selectedFood ->
        navController.navigate("food/${selectedFood.id}")
    }

    val selectedFoodType = remember {
        mutableStateOf(FoodType.MainCourse) // Added default selection
    }
    val foodsState = remember {
        mutableStateListOf<Food>().apply {
            addAll(foods.filter { it.type == selectedFoodType.value })
        }
    }
    val onLikeChange: (Food) -> Unit = {
        val index = foodsState.indexOf(it)
        if (index != -1) {
            foodsState[index] = it.copy(liked = !it.liked)
        }
    }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Our Menu",


            )
             }
        )
    }) { paddings ->
        Column(modifier = Modifier.padding(paddings)) {
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(items = FoodType.entries.toTypedArray()) { _, foodType ->
                    Box(
                        modifier = Modifier
                            .clip(
                                CircleShape

                            )
                            .sizeIn(minWidth = 80.dp, minHeight = 30.dp)


                            .background(
                                   color = if (selectedFoodType.value == foodType) Color(0xffe0e0e0) else Color.Transparent

                            ).clickable {
                                selectedFoodType.value = foodType
                                foodsState.clear()
                                foodsState.addAll(foods.filter { it.type == selectedFoodType.value })
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        val ubuntuFont = null
                        Text(
                            text = foodType.name,
                            fontSize = 14.sp,
                            fontFamily = ubuntuFont,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            color = if (selectedFoodType.value == foodType) Color(0xff313131) else Color(0xffa1a1a1),
                            fontStyle = if (selectedFoodType.value == foodType) FontStyle.Normal else FontStyle.Italic
                        )



                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Foods(
                items = foodsState,
                onLikeChange = onLikeChange,
                onTap = onFoodItemClick
            )
        }
    }
}



@Preview (showBackground = true,
    showSystemUi = true,


    )

@Composable
fun HomeScreenPreview(
    modifier: Modifier = Modifier
) {
    HomeScreen(navController = NavController(LocalContext.current))
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Foods(
    items: List<Food>,
    onLikeChange: (Food) -> Unit,
    onTap: (Food) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xfff1f1f1))
            .padding(horizontal = 8.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items = items) { index, food ->
                FoodItem(food = food, onLikeChange = onLikeChange, onTap = onTap)
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(
    food: Food,
    onLikeChange: (Food) -> Unit,
    onTap: (Food) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (food.liked) Color(0xffe6e6e6) else Color(0xfff1f1f1)
        ),
        onClick = { onTap(food) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)

        ) {
            Image(
                painter = painterResource(id = food.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp, max = 150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = food.name,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth(),
                fontSize = if (food.name.length > 20) 14.sp else 17.sp,
                color = Color(0xff313131),
                maxLines = 1
                ,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,




            ) {
                Text(
                    text = "${food.price}$",
                    modifier = Modifier,
                    fontSize = 18.sp,




                    color = Color(0xff313131)
                )



                Text(
                    text = "${food.preparationTimeMinutes} min",
                    fontSize = 18.sp,
                    color = Color(0xff313131),

                )
            }
        }
    }
}

