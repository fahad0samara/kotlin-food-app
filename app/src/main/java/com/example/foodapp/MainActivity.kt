package com.example.foodapp

import android.annotation.SuppressLint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController

import com.example.foodapp.navgtion.Navigation
import com.example.foodapp.ui.theme.FoodAppTheme

data class BottomNavigationItem(
    val titel: String,
    val badgeCount: Int? = null,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String? = null
    //router


)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
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
                        unselectedIcon = Icons.Outlined.Search
                    ),


                )
                var selectedItem by rememberSaveable{
                    mutableIntStateOf(0)
                }
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold (bottomBar = {
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
                                        val route = when (index) {
                                            0 -> "home"
                                            1 -> "search"
                                            2 -> "cart"
                                            3 -> "profile"
                                            else -> "home" // Handle default case
                                        }
                                        navController.navigate(route)
                                    }
                                )






                            }

                        }

                    })

                    {
                        Navigation()

                    }
                }
            }
        }
    }
}

