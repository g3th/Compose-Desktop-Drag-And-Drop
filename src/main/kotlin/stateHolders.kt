import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

class StateHolders {
  var targetLocalPosition by mutableStateOf(Offset.Zero)
  var objectLocalPosition by mutableStateOf(Offset.Zero)
  var animalToMatch by mutableStateOf("")
  var isDragging by mutableStateOf(false)
  var colorChange by mutableStateOf(Color.LightGray)
}

val uiStates = compositionLocalOf { StateHolders() }