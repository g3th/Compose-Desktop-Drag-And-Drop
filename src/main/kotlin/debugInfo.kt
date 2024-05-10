import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Window
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun Debug(){
  val state = uiStates.current
  Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
    .background(Color.LightGray)){
    Text(fontSize = 20.sp, text = "Current Animal to Match: ${state.animalToMatch}")
    Text(fontSize = 20.sp, text = "Draggable Pos: X = ${state.objectLocalPosition.x} : Y = ${state.objectLocalPosition.y}")
    Text(fontSize = 20.sp, text = "Target Pos: X = ${state.targetLocalPosition.x} : Y = ${state.targetLocalPosition.y}")
    Text(fontSize = 20.sp, text = "DRAG ENTERED: ${state.isDragging}")
  }
}
