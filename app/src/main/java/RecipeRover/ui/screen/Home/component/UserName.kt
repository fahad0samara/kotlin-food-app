package RecipeRover.ui.screen.Home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.fahad.RecipeRover.ui.screen.UserDataViewModel
import RecipeRover.ui.theme.dimens
import java.time.LocalTime

@Composable
fun UserName(
  userDataViewModel: UserDataViewModel
) {
  val user by userDataViewModel.user.collectAsState() // Observe the user state
  val painter = rememberAsyncImagePainter(
    ImageRequest.Builder(LocalContext.current).data(
      data = user?.photoUrl
    ).apply(block = fun ImageRequest.Builder.() {
      crossfade(true)
      transformations(CircleCropTransformation())
      scale(Scale.FILL)
    }).build()

  )

  val currentUser = user ?: return
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        horizontal = dimens.small3,
      ),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    val greeting = when (LocalTime.now().hour) {
      in 0..11 -> "Good morning"
      in 12..17 -> "Good afternoon"
      else -> "Good evening"
    }

    Column {
      Text(
        text = "$greeting, ${currentUser.displayName}",
        fontSize = MaterialTheme.typography.headlineMedium.fontSize
      )
      Text(
        text = "Let's find you something to eat!",
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
        fontStyle = FontStyle.Italic,
        color = MaterialTheme.colorScheme.primary
      )
    }

    Spacer(modifier = Modifier.width(dimens.small3))

    // Display user's profile picture or a placeholder image if not available
    Image(
      painter = painter,
      contentDescription = null,
      modifier = Modifier
        .size(dimens.logoSize1)
        .background(MaterialTheme.colorScheme.primary, CircleShape),
      contentScale = ContentScale.Crop
    )
  }
}