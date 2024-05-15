import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color


data class CollisionValues(val mState: Boolean, val hasCollided: Boolean, val listenerOffset: Offset)

class Collisions {
  var listenerOffset = Offset(0f,0f)
  fun detect(dragObjectOffset: Offset, dragListenerOffset: List<Offset>): CollisionValues {
    var matchState = false
    var hasCollided = false
    for (i in dragListenerOffset.indices){
      if (dragObjectOffset.x in dragListenerOffset[i].x - 15 .. dragListenerOffset[i].x + 15 &&
        dragObjectOffset.y in dragListenerOffset[i].y - 15 .. dragListenerOffset[i].y + 15) {
        listenerOffset = Offset(dragListenerOffset[i].x, dragListenerOffset[i].y)
        matchState = true
        hasCollided = true
        }
      }
    return CollisionValues(matchState, hasCollided, listenerOffset)
  }
}