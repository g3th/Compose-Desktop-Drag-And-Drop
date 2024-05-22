import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun restartButton(totalNumberOfAnimals: Int){
  val states = uiStates.current
  Button(modifier = Modifier.size(100.dp,50.dp),
    onClick={
      states.clearAllValues()
      states.animalMatch.clear()
      for (i in 0 until totalNumberOfAnimals){
        states.animalMatch.add(false)
      }
      states.allAnimalsMatched
    }){
    Text("Restart")
  }
}

@Composable
fun dragEventObject(currentAnimalIndex: Int,
                    totalNumberOfAnimals: Int,
                    animal: String,
                    startingOffset: Offset,
                    dragEventObjectShape: String,
                    composable: @Composable ( () -> Unit) ){
  val currentState = uiStates.current
  var startGradient by remember {mutableStateOf(individualDragEventObjectColors(animal).startColorGrad)}
  var endGradient by remember {mutableStateOf(individualDragEventObjectColors(animal).endColorGrad)}
  var dragShadow by remember { mutableStateOf(1f) }
  var matched by remember { mutableStateOf(false)}
  var localOffset by remember { mutableStateOf(startingOffset)}
  val shape = BoxShapes(dragEventObjectShape)
  for (i in 0 until totalNumberOfAnimals){
    currentState.animalMatch.add(false)
  }
  if(!currentState.animalMatch[currentAnimalIndex]){
    Box{
    composable()
    Image(painter = painterResource("blank.png"), contentDescription = null, Modifier
      .offset(localOffset.x.dp, localOffset.y.dp)
      .alpha(dragShadow)
      .pointerInput(Unit) {
        val collisions = Collisions()
        detectDragGestures(onDragStart = {
          dragShadow = 0.2f
        }, onDrag = { _, dragAmount ->
          //Debug Window
          currentState.hasCollided = collisions.detect(currentState.objectLocalPosition,
            currentState.targetLocalPosition).hasCollided
          currentState.currentListenerOffset = collisions.detect(currentState.objectLocalPosition,
            currentState.targetLocalPosition).listenerOffset
          localOffset += dragAmount
        }, onDragEnd = {
          currentState.animalMatch[currentAnimalIndex] = collisions.detect(currentState.objectLocalPosition,
            currentState.targetLocalPosition).mState
          if (currentState.animalMatch[currentAnimalIndex]) {
            currentState.allAnimalsMatched++
          }
          println(currentState.allAnimalsMatched)
          dragShadow = 1f
          localOffset = startingOffset
        })
      }
      .onGloballyPositioned {
        currentState.objectLocalPosition = it.localToWindow(Offset.Zero)
      }
      .clip(shape)
      .clickable(onClick = {
        startGradient = individualDragEventObjectColors(animal).startColorGrad
        endGradient = individualDragEventObjectColors(animal).endColorGrad
      })
      .background(Brush.linearGradient(listOf(startGradient[animal]!!, endGradient[animal]!!)))
    )}
  }
}

@Composable
fun drawRestartButton(numberOfAnimals: Int){
  val currentState = uiStates.current
  Box(modifier = Modifier
    .offset(440.dp,300.dp)) {
    if (currentState.allAnimalsMatched == numberOfAnimals) {
      restartButton(numberOfAnimals)
    }
  }
}