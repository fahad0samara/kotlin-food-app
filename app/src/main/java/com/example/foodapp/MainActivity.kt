package com.example.foodapp


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize



import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface


import androidx.compose.ui.Modifier

import com.example.foodapp.navgtion.NavBatoom

import com.example.foodapp.navgtion.Navigation
import com.example.foodapp.ui.theme.FoodAppTheme


class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold (bottomBar = {
                        NavBatoom()

                    }
                       )

                    {
                        Navigation()

                    }
                }
            }
        }
    }
}

