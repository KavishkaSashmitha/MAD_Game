// com.example.falling.com.example.falling.com.example.falling.com.example.falling.com.example.falling.GameView.kt
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GameView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint: Paint = Paint()
    private var xPosition = 0f
    private var yPosition = 0f

    init {
        paint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(xPosition, yPosition, 50f, paint)
    }

    fun updatePosition(x: Float, y: Float) {
        xPosition = x
        yPosition = y
        invalidate()
    }
}
