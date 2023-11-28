package com.fahad.RecipeRover.ui.screen.auth.compenets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.fahad.RecipeRover.domain.model.Response
import com.fahad.RecipeRover.ui.theme.dimens

@Composable
 fun DisplayError(loginResult: Response<Any>) {
    if (loginResult is Response.Failure) {
        Text(
            text = (loginResult ).exception.message ?: "Unknown error",
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimens.small1)
        )
    }
}
