import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import java.text.DecimalFormat
import kotlin.random.Random

class BoxShapes(animal: String): Shape {
  private val fetchAnimal = animal
  override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
    val parser = PathParser()
    val matrix = Matrix()
    val path = parser.parsePathString(PathStrings.valueOf(fetchAnimal).pathValue).toPath()
    matrix.scale(1.5f, 1.5f)
    path.transform(matrix)
    return Outline.Generic(path)
  }
}

class ColorGenerator {
  private var colorValues = mutableListOf<Float>()

  fun randomColor(): List<Color>{
    for (i in 0 until 6) {
      val r = Random.nextFloat()
      val parse = DecimalFormat("#.#")
      val value = parse.format(r)
      colorValues.add(value.toFloat())
    }
    val colors = listOf(
      Color(colorValues[0], colorValues[1], colorValues[2]),
      Color(colorValues[3], colorValues[4], colorValues[5])
    )
    return colors
  }
}


data class ColorsReturns(val startColorGrad: MutableMap<String, Color>, val endColorGrad: MutableMap<String, Color>)

fun individualDragEventObjectColors(animal: String): ColorsReturns{
  val colors = ColorGenerator().randomColor()
  val startColorGradient = mutableMapOf(animal to colors[0])
  val endColorGradient = mutableMapOf(animal to colors[1])
  return ColorsReturns(startColorGradient, endColorGradient)
}