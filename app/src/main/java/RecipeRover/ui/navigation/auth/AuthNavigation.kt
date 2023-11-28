//package com.fahad.tastybite.ui.navigation.auth
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//
//import com.fahad.tastybite.ui.screen.auth.login.LoginScreen
//import com.fahad.tastybite.ui.screen.auth.register.RegisterScreen
//import com.fahad.tastybite.ui.screen.auth.login.LoginViewModel
//import com.fahad.tastybite.ui.screen.auth.register.RegisterViewModel
//
//fun NavGraphBuilder.authNavigation(navController: NavHostController,
//                                   loginViewModel: LoginViewModel,
//                                   registerViewModel: RegisterViewModel,
//
//) {
//
//  navigation(
//    route = Graph.AUTHENTICATION.route,
//    startDestination = AuthScreen.LOGIN.route
//
//  )
//
//
//  {
//
//    composable( AuthScreen.LOGIN.route) {
//      LoginScreen(
//        navController = navController, loginViewModel = loginViewModel
//      )
//    }
//    composable( AuthScreen.REGISTER.route) {
//      RegisterScreen(
//        navController = navController, registerViewModel = registerViewModel
//      )
//    }
//
//  }
//}
//
//sealed class AuthScreen(val route: String) {
//  data object LOGIN : AuthScreen("login")
//  data object REGISTER : AuthScreen("register")
//
//
//
//
//
//
//}
//
//
