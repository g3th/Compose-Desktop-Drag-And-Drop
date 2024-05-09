import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
fun GUI(){
  mainLayout()
  dragAndDropOperation()
  Debug()
}

fun main() = application {
  Window(onCloseRequest = ::exitApplication,
    state = WindowState(width = 1000.dp, height=800.dp),
    resizable = false,
    title = "Drag And Drop") {
    GUI()
  }
}