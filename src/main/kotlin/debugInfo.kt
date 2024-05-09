import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Debug(){
  val state = uiStates.current
  CompositionLocalProvider(uiStates provides StateHolders()){
    Column(modifier = Modifier
      .offset(680.dp,200.dp)
      .background(Color.LightGray)){
      Text(fontSize = 20.sp, text = "Debug:")
      Text(fontSize = 17.sp, text = "Draggable Pos: X = ${state.objectLocalPosition.x} : Y = ${state.objectLocalPosition.y}")
      Text(fontSize = 17.sp, text = "Target Pos: X = ${state.targetLocalPosition.x} : Y = ${state.targetLocalPosition.y}")
      Text(fontSize = 17.sp, text = "DRAG ENTERED: ${state.isDragging}")
    }
  }
}