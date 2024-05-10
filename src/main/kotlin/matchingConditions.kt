import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color


data class CollisionValues(val mState: Boolean, val collisionColorChange: Color, val hasCollided: Boolean)

class Collisions {
  fun detect(dragObjectOffset: Offset, dragListenerOffset: Offset): CollisionValues {
    val changeColorOnCollision: Color
    val matchState: Boolean
    val hasCollided: Boolean
    if (dragObjectOffset.x in dragListenerOffset.x - 15 .. dragListenerOffset.x + 15 &&
      dragObjectOffset.y in dragListenerOffset.y - 15 .. dragListenerOffset.y + 15) {
      changeColorOnCollision = Color.Red
      matchState = true
      hasCollided = true
    } else {
      changeColorOnCollision = Color.LightGray
      matchState = false
      hasCollided = false
    }
    return CollisionValues(matchState, changeColorOnCollision, hasCollided)
  }
}