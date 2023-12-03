package com.fahad.RecipeRover.ui.screen.auth.compenets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import RecipeRover.ui.theme.dimens

@Composable
fun NavigationText(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimens.small3)
    ) {
        Text(text,
            style = MaterialTheme.typography.labelMedium,



          )
    }
}
