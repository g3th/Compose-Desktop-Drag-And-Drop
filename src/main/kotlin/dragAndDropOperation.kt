import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun dragAndDropOperation() {
  val state = uiStates.current
  Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row {
      val startingOffset = Offset(150f, 250f)
      val animalShapes = listOf("Horse", "Dog")
      for (i in animalShapes.indices) {
        val shape = BoxShapes(animalShapes[i])
        dragListener(i, shape, Pair(200, -100))
        dragEventObject(animalShapes[i], startingOffset, animalShapes[i], composable = {
          Image(
            painter = painterResource("blank.png"),
            contentDescription = null,
            modifier = Modifier
              .offset(startingOffset.x.dp, startingOffset.y.dp)
              .clip(shape)
              .background(Color.LightGray))
        })
      }
    }
  }
}