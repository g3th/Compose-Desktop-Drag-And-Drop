import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color


data class CollisionValues(val mState: Boolean, val collisionColorChange: Color, val hasCollided: Boolean)

class Collisions {
  fun detect(dragObjectOffset: Offset, dragListenerOffset: List<Offset>): CollisionValues {
    var changeColorOnCollision = Color.Black
    var matchState = false
    var hasCollided = false
    for (i in dragListenerOffset.indices){
      if (dragObjectOffset.x in dragListenerOffset[i].x - 15 .. dragListenerOffset[i].x + 15 &&
        dragObjectOffset.y in dragListenerOffset[i].y - 15 .. dragListenerOffset[i].y + 15) {
          changeColorOnCollision = Color.Red
          matchState = true
          hasCollided = true
        }
      }
    return CollisionValues(matchState, changeColorOnCollision, hasCollided)
  }
}