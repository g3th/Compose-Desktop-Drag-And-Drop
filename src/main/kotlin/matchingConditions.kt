import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color


data class CollisionValues(val mState: Boolean, val mText: Color, val hasCollided: Boolean)
class Collisions {

  fun detect(dragObjectOffset: Offset, dragListenerOffset: Offset): CollisionValues {
    val matchText: Color
    val matchState: Boolean
    var hasCollided: Boolean
    if (dragObjectOffset.x in dragListenerOffset.x - 10 .. dragListenerOffset.x + 10 &&
      dragObjectOffset.y in dragListenerOffset.y - 10 .. dragListenerOffset.y + 10) {
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