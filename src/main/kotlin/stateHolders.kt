import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

class StateHolders {
  val numberOfAnimals = PathStrings.entries.size
  var targetLocalPosition: List<Offset> by mutableStateOf(listOf())
  var objectLocalPosition by mutableStateOf(Offset.Zero)
  var hasCollided by mutableStateOf(false)
  var currentOffset: MutableMap<Offset, Color> = mutableStateMapOf()
  var cOffset by mutableStateOf(Offset(0f,0f))
}

val uiStates = compositionLocalOf { StateHolders() }
