import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun dragAndDropOperation() {
  val generator = ColorGenerator()
  val (start, end) = generator.randomColor()
  val startColor by remember { mutableStateOf(start) }
  val endColor by remember { mutableStateOf(end) }
  Column(
    modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row {
      val startingOffset = Offset(350f, 250f)
      val animalShapes = listOf("Horse", "Dog")
      val randomAnimal = animalShapes[Random.nextInt(animalShapes.size)]
      val horse = BoxShapes(randomAnimal)
      dragListener(horse, Pair(400, -100))
      for (i in animalShapes){
        val shape = BoxShapes(i)
        dragEventObject(startColor, endColor, startingOffset, randomAnimal, i, composable = {
          Image(
            painter = painterResource("blank.png"),
            contentDescription = null,
            modifier = Modifier
              .offset(startingOffset.x.dp, startingOffset.y.dp)
              .clip(shape)
              .background(Brush.linearGradient(listOf(startColor, endColor)))
          )
        })
      }
    }
  }
}