package com.example.falling// com.example.falling.FallingObject.kt
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.util.Random

class FallingObject(private val screenWidth: Float, private val screenHeight: Float) {
    var x = Random().nextFloat() * screenWidth
    var y = 0f
    private val speed = Random().nextInt(10) -5 // Adjust speed as needed
    private val size = 50f

    fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.RED
        canvas.drawCircle(x, y, size / 2, paint)
    }

    fun update() {
        y += speed
    }

    fun reset() {
        y = 0f
        x = Random().nextFloat() * screenWidth
    }

    fun checkCollision(catcherLeft: Float, catcherRight: Float, catcherTop: Float, catcherBottom: Float): Boolean {
        return x + size / 2 > catcherLeft && x - size / 2 < catcherRight && y + size / 2 > catcherTop && y - size / 2 < catcherBottom
    }
}
