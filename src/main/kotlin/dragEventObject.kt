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
import androidx.compose.ui.unit.dp

@Composable
fun dragEventObject(startingOffset: Offset,
                    dragEventObjectShape: String,
                    composable: @Composable ( () -> Unit) ){
  val currentState = uiStates.current
  var dragShadow by remember { mutableStateOf(1f) }
  var matched by remember { mutableStateOf(false)}
  var localOffset by remember { mutableStateOf(startingOffset)}
  val shape = BoxShapes(dragEventObjectShape)
    if(!matched){
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
          currentState.isDragging = collisions.detect(currentState.objectLocalPosition,
            currentState.targetLocalPosition).hasCollided
          //Object Color Changes on Collision
          currentState.colorChange = collisions.detect(currentState.objectLocalPosition,
            currentState.targetLocalPosition).collisionColorChange
          localOffset += dragAmount
        }, onDragEnd = {
          matched = collisions.detect(currentState.objectLocalPosition,
            currentState.targetLocalPosition).mState
          dragShadow = 1f
          localOffset = startingOffset
        })
      }
      .onGloballyPositioned {
        currentState.objectLocalPosition = it.localToWindow(Offset.Zero)
      }
      .clip(shape)
      .clickable(onClick = {
        currentState.colorGen()
      })
      .background(Brush.linearGradient(listOf(currentState.startColor, currentState.endColor)))
    )}
  }
  else {
    // TODO
  }
}