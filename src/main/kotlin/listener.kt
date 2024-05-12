import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun dragListener(shape: Shape, modifierOffset: Pair<Int, Int>){
  val currentState = uiStates.current
    Image(painter= painterResource("blank.png"), contentDescription = null, Modifier
      .offset(modifierOffset.first.dp, modifierOffset.second.dp)
      .onGloballyPositioned{
        currentState.targetLocalPosition.add(it.localToRoot(Offset(0f,0f)))
      }
      .clip(shape)
      .alpha(0.5f)
      .background(currentState.colorChange)
    )
}