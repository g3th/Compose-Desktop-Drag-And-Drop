import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset

class StateHolders {
  val numberOfAnimals = PathStrings.entries.size
  var targetLocalPosition: List<Offset> by mutableStateOf(listOf())
  var objectLocalPosition by mutableStateOf(Offset.Zero)
  var hasCollided by mutableStateOf(false)
  var currentListenerOffset by mutableStateOf(Offset(0f,0f))
}

val uiStates = compositionLocalOf { StateHolders() }
