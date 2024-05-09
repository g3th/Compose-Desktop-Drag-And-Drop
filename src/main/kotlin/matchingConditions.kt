import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color


data class CollisionValues(val mState: Boolean, val mText: Color, val hasCollided: Boolean)
class Collisions {

  fun detect(dObj: Offset, tar: Offset): CollisionValues {
    val matchText: Color
    val matchState: Boolean
    var hasCollided: Boolean
    if (dObj.x in tar.x - 10 .. tar.x + 10 &&
      dObj.y in tar.y - 10 .. tar.y + 10) {
      matchText = Color.Red
      matchState = true
      hasCollided = true
    } else {
      matchText = Color.LightGray
      matchState = false
      hasCollided = false
    }
    return CollisionValues(matchState, matchText, hasCollided)
  }
}