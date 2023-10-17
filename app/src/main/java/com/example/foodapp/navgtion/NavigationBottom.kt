package com.example.foodapp.navgtion

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

import androidx.compose.material.icons.filled.Search

import androidx.compose.material.icons.outlined.Home

import androidx.compose.material.icons.outlined.Search

import androidx.compose.material3.ExperimentalMaterial3Api


import androidx.compose.ui.graphics.vector.ImageVector





data class BottomNavigationItem(
    val titel: String,
    val badgeCount: Int? = null,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String? = null
    //router


)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBatoom() {
    var selectedItem by rememberSaveable{
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(
            titel = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "home"
        ),
        BottomNavigationItem(
            titel = "Search",

            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = "Search"
        ),


        )


    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }

                            }


                        }
                    ) {
                        Icon(
                            imageVector = if (selectedItem == index) item.selectedIcon else item.unselectedIcon,
                            contentDescription = null
                        )




                    }

                },
                label = { Text(text = item.titel) },

                selected = selectedItem == index,
                onClick = {
                    selectedItem = index

                    item.route?.let {
                        navController.navigate(
                            it
                        )
                    }
                }
            )






        }

    }

}

