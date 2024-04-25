package com.example.falling

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameView = findViewById(R.id.gameView)

        // Game loop
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                gameView.update()
                handler.postDelayed(this, 30) // Adjust delay as needed
            }
        }
        handler.post(runnable)
    }

    fun getGameViewInstance(): GameView {
        return gameView
    }
}
