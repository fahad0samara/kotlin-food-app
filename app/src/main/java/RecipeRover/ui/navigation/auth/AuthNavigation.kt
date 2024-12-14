package RecipeRover.ui.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fahad.RecipeRover.ui.screen.auth.login.LoginScreen
import RecipeRover.ui.screen.auth.login.LoginViewModel
import com.fahad.RecipeRover.ui.screen.auth.register.RegisterScreen
import com.fahad.RecipeRover.ui.screen.auth.register.RegisterViewModel

fun NavGraphBuilder.authNavigation(navController: NavHostController,
                                   loginViewModel: LoginViewModel,
                                   registerViewModel: RegisterViewModel,

                                   ) {

  navigation(
    startDestination = "login",
    route = "auth",



  )


  {


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

  }
}




