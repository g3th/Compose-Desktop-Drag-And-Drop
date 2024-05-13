import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

class StateHolders {
  var targetLocalPosition: List<Offset> by mutableStateOf(listOf())
  var objectLocalPosition by mutableStateOf(Offset.Zero)
  var hasCollided by mutableStateOf(false)
}

val uiStates = compositionLocalOf { StateHolders() }


