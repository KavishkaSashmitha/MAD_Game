package com.example.falling

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.Random

class GameView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()
    private var catcherX = 0f
    private var catcherWidth = 50f
    private val catcherHeight = 50f
    private var bucketX = 0f
    private var bucketWidth = 300f
    private val bucketHeight = 100f
    private var score = 0
    private var fallingObjects: MutableList<FallingObject> = mutableListOf()
    private var gameOver = false

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw ground
        paint.color = Color.GRAY
        canvas.drawRect(0f, height - bucketHeight, width.toFloat(), height.toFloat(), paint)
        paint.color = Color.BLUE // Reset color to blue

        // Draw bucket image
        val bucketBitmap = BitmapFactory.decodeResource(resources, R.drawable.bucket)
        val desiredVerticalOffset = 40f;
        val bucketY = height - bucketHeight - desiredVerticalOffset // Adjust the desiredVerticalOffset as needed
        canvas.drawBitmap(bucketBitmap, bucketX, bucketY, paint)

        // Draw falling objects
        for (obj in fallingObjects) {
            obj.draw(canvas, paint)
        }

        // Draw score
        paint.textSize = 50f
        canvas.drawText("Score: $score", 50f, 100f, paint)

        // Inside com.example.falling.GameView class, when game over is detected
        if (gameOver) {
            // Start com.example.falling.GameOverActivity and pass the score
            val intent = Intent(context, GameOverActivity::class.java)
            intent.putExtra("score", score)
            context.startActivity(intent)
        }

    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!gameOver) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    catcherX = event.x - catcherWidth / 2
                    bucketX = event.x - bucketWidth / 2
                    invalidate()
                }
            }
        }
        return true
    }
    fun resetGame() {
        // Set the initial score to 0
        score = 0

        // Reset other variables and flags to their initial state
        catcherX = 0f
        bucketX = 0f
        fallingObjects.clear()
        gameOver = false

        // Invalidate the view to redraw with the updated score
        invalidate()
    }


    fun update() {
        if (!gameOver) {
            // Update falling objects
            for (obj in fallingObjects) {
                obj.update()

                // Check for collision with catcher or bucket
                if (obj.checkCollision(catcherX, catcherX + catcherWidth, height - catcherHeight, height.toFloat()) ||
                    obj.checkCollision(bucketX, bucketX + bucketWidth, height - bucketHeight, height.toFloat())) {
                    score++
                    obj.reset()
                }


                // Check if object reached bottom
                if (obj.y > height) {
                    gameOver = true
                }
            }

            // Generate new falling object
            if (Random().nextInt(100) < 10) { // Adjust probability as needed
                fallingObjects.add(FallingObject(width.toFloat(), height.toFloat()))
            }

            invalidate()
        }
    }
}
