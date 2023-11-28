package com.fahad.tastybite.ui.navigation

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fahad.tastybite.R



import com.fahad.tastybite.ui.navigation.bottom.BottomBarRoot
import com.fahad.tastybite.ui.screen.UserDataViewModel
import com.fahad.tastybite.ui.screen.auth.login.LoginScreen
import com.fahad.tastybite.ui.screen.auth.login.LoginViewModel
import com.fahad.tastybite.ui.screen.auth.register.RegisterScreen
import com.fahad.tastybite.ui.screen.auth.register.RegisterViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.delay

@Composable
fun RootNavigation(navController: NavHostController) {
  val loginViewModel: LoginViewModel = hiltViewModel()
  val registerViewModel: RegisterViewModel = hiltViewModel()
  val userDataViewModel: UserDataViewModel = hiltViewModel()

  // Check authentication state when the RootNavigationGraph is recomposed
  LaunchedEffect(Unit) {
    // Simulate a splash screen delay if needed
    delay(1000) // 2 seconds delay, adjust as needed

    // Check authentication state
    if (Firebase.auth.currentUser == null) {
      // Navigate to the login screen if the user is not authenticated
      navController.navigate("login")
    } else {
      // Navigate to the home screen if the user is authenticated
      navController.navigate("home")
    }
  }

  // In RootNavigation composable
  NavHost(
    navController = navController, route = "root"
    , startDestination = "splash"
  ) {
    composable(route = "splash") {
      SplashScreen()
    }

    composable("login") {
      LoginScreen(
        navController = navController, loginViewModel = loginViewModel
      )
    }
    composable( "register") {
      RegisterScreen(
        navController = navController, registerViewModel = registerViewModel
      )
    }

    composable(route = "home") {
      BottomBarRoot()
    }
  }




}





  @Composable
  fun SplashScreen() {
    Box(
      modifier = Modifier.fillMaxSize(),

      contentAlignment = Alignment.Center
    ) {
      // Add your splash screen content
      Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
      ) {

        Image(
          painter = painterResource(id = R.drawable.logo),

          contentDescription = null,
          alignment = Alignment.Center,
          modifier = Modifier.height(300.dp)

        )

      }
    }

  }





