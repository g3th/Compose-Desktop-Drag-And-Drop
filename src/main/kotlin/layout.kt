import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun information(){
  Text(fontSize = 20.sp, fontWeight = FontWeight.Bold, text="1. Click the animal shape to change colors")
  Text(fontSize = 20.sp, fontWeight = FontWeight.Bold, text="2. Match the Animal shape")
  Text(fontSize = 20.sp, fontWeight = FontWeight.Bold, text="HINT: The gray animal will change color if it's ready to receive the dropped object.")
}

@Composable
fun mainLayout() {
  Scaffold(topBar = {
    TopAppBar(title = {
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center ) {
        Text(
          text = "Drag And Drop Example",
          fontWeight = FontWeight.Bold,
          fontSize = 30.sp,
          textAlign = TextAlign.Right
        )
      }
    },//102 204 0 - 178 255 102
      modifier = Modifier
        .background(
          Brush.linearGradient(colors = listOf(
            Color(102 ,204 ,0),
          Color(178 , 255 , 102) ))),
      backgroundColor = Color.Transparent,
      elevation = 0.dp)
  })//0 204 102 - 102 255 178
  {
    Column(modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(0.2f)
      .background(
        Brush.verticalGradient(listOf(
          Color(0, 204, 102),
        Color(102 ,255 ,178)
        ))),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center){
      information()
    }
  }
}
