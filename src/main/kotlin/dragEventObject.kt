import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable
fun dragEventObject(startC:Color,
                    endC: Color,
                    startingOffset: Pair<Int,Int>,
                    animalShape: String,
                    composable: @Composable ( () -> Unit) ){
  var startColor by remember{ mutableStateOf(startC) }
  var endColor by remember{ mutableStateOf(endC) }
  val currentState = uiStates.current
  currentState.currentOffset = Offset(startingOffset.first.toFloat(), startingOffset.second.toFloat())
  var dragShadow by remember { mutableStateOf(1f) }
  val shape = BoxShapes(animalShape)
  Box {
    if (!currentState.matched) {
      composable()
      Image(painter = painterResource("blank.png"), contentDescription = null, Modifier
        .offset { IntOffset(currentState.currentOffset.x.roundToInt(), currentState.currentOffset.y.roundToInt()) }
        .alpha(dragShadow)
        .pointerInput(Unit) {
          val collisions = Collisions()
          detectDragGestures(onDragStart = {
            currentState.isDragging = true
            dragShadow = 0.2f
          }, onDrag = { _, dragAmount ->
            currentState.colorChange = collisions.detect(currentState.objectLocalPosition,
              currentState.targetLocalPosition).mText
            currentState.isDragging = collisions.detect(currentState.objectLocalPosition,
              currentState.targetLocalPosition).hasCollided
            currentState.currentOffset += dragAmount
          }, onDragEnd = {
            currentState.matched = collisions.detect(currentState.objectLocalPosition,
              currentState.targetLocalPosition).mState
            dragShadow = 1f
            currentState.currentOffset = Offset.Zero
          })
        }
        .onGloballyPositioned {
          currentState.objectLocalPosition = it.localToWindow(Offset.Zero)
        }
        .clip(shape)
        .clickable(onClick = {
          val newGenerator = ColorGenerator()
          val (aNewStart, aGoodEnding) = newGenerator.randomColor()
          startColor = aNewStart
          endColor = aGoodEnding
        })
        .background(Brush.linearGradient(listOf(startColor, endColor)))
      )
    }
    else {
      // TODO
    }
  }
}