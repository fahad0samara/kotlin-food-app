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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.fahad.RecipeRover.ui.screen.UserDataViewModel
import java.time.LocalTime

@Composable
fun UserName(
    userDataViewModel: UserDataViewModel
) {
  val user by userDataViewModel.user.collectAsState() // Observe the user state
  val painter = rememberAsyncImagePainter(
    ImageRequest.Builder(LocalContext.current).data(data =
    user?.photoUrl
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
        horizontal = 16.dp
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
        fontSize = MaterialTheme.typography.labelMedium.fontSize,
        fontStyle = FontStyle.Italic,
        color = MaterialTheme.colorScheme.primary
      )
    }

    Spacer(modifier = Modifier.width(16.dp))

    // Display user's profile picture or a placeholder image if not available
    Image(
      painter = painter,
      contentDescription = null,
      modifier = Modifier
        .size(50.dp)
        .background(Color(0xFF91F1FF), CircleShape),
      contentScale = ContentScale.Crop
    )
  }
}