import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import java.text.DecimalFormat
import kotlin.random.Random


class StateHolders {
  var targetLocalPosition by mutableStateOf(mutableListOf(Offset.Zero))
  var objectLocalPosition by mutableStateOf(Offset.Zero)
  var startColor by mutableStateOf(Color.LightGray)
  var endColor by mutableStateOf(Color.LightGray)
  var isDragging by mutableStateOf(false)
  var colorChange by mutableStateOf(Color.Gray)
  var matched by mutableStateOf(false)

  init {
    val colors = ColorGenerator().randomColor()
    startColor = colors[0]
    endColor = colors[1]
  }

  fun colorGen() {
    val colors = ColorGenerator().randomColor()
    startColor = colors[0]
    endColor = colors[1]
  }
}

val uiStates = compositionLocalOf { StateHolders() }