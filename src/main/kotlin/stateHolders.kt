import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset

class StateHolders() {
  var targetLocalPosition: MutableList<Offset> by mutableStateOf(mutableStateListOf())
  var objectLocalPosition by mutableStateOf(Offset.Zero)
  var hasCollided by mutableStateOf(false)
  var currentListenerOffset by mutableStateOf(Offset(0f,0f))
  var animalMatch: MutableList<Boolean> by mutableStateOf(mutableStateListOf())
  var allAnimalsMatched by mutableStateOf(0)


  fun clearAllValues(){
    targetLocalPosition.clear()
    objectLocalPosition = Offset.Zero
    hasCollided = false
    currentListenerOffset = Offset(0f,0f)
    allAnimalsMatched = 0
  }
}

val uiStates = compositionLocalOf { StateHolders() }

