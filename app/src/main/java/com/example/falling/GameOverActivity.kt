package com.example.falling
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val score = intent.getIntExtra("score", 0)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = "Score: $score"

        val restartButton = findViewById<Button>(R.id.restartButton)
        restartButton.setOnClickListener {
            // Start the MainActivity again
            val mainActivityIntent = Intent(this@GameOverActivity, MenuActivity::class.java) // Change GameView to MainActivity
            startActivity(mainActivityIntent)

            // Finish this activity
            finish()
        }

    }
}
