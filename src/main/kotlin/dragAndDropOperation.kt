import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun dragAndDropOperation() {
  val generator = ColorGenerator()
  val (start, end) = generator.randomColor()
  val startColor by remember { mutableStateOf(start) }
  val endColor by remember { mutableStateOf(end) }
  val animals = listOf("Horse")
  val horse = BoxShapes(animals[0])
  Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row {
      val startingOffset = Pair(550, 250)
      dragListener(horse, Pair(0, -100))
      dragEventObject(startColor, endColor, startingOffset, "Horse", composable = {
        Image(
          painter = painterResource("blank.png"),
          contentDescription = null,
          modifier = Modifier
            .offset(startingOffset.first.dp, startingOffset.second.dp)
            .clip(horse)
            .background(Brush.linearGradient(listOf(startColor, endColor)))
        )
      })
    }
  }
}