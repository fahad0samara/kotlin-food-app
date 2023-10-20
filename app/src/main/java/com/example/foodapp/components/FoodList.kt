package com.example.foodapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R
import com.example.foodapp.data.Food
import com.example.foodapp.data.FoodType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodList(
    items: List<Food>,


    onTap: (Food) -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxSize()

            .padding(horizontal = 8.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items = items) { index, food ->
                FoodItem(food = food,  onTap = onTap,


                    )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodItem(
    food: Food,

    onTap: (Food) -> Unit,


) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()

            .padding(8.dp),

        onClick = { onTap(food) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(
                    color = if (isSystemInDarkTheme()) {
                        colorResource(
                            id = R.color.transparent_black
                        )


                    } else {
                        colorResource(
                            id = R.color.transparent_white
                        )

                    }


                )


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

                color = if (isSystemInDarkTheme()) {
                    colorResource(
                        id = R.color.white
                    )


                } else {
                    colorResource(
                        id = R.color.black
                    )
                },

                fontSize = if (food.name.length > 20) 14.sp else 17.sp,
                maxLines = 1,
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
                    color = if (isSystemInDarkTheme()) {
                        colorResource(
                            id = R.color.white
                        )


                    } else {
                        colorResource(
                            id = R.color.black
                        )
                    }


                )



                Text(
                    text = "${food.preparationTimeMinutes} min",
                    fontSize = 18.sp, color = if (isSystemInDarkTheme()) {
                        colorResource(
                            id = R.color.white
                        )


                    } else {
                        colorResource(id = R.color.black)
                    }
                )
            }
        }



        }
    }



























