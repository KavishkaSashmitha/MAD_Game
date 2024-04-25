package com.example.falling

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Initialize buttons
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnHighScore = findViewById<Button>(R.id.btnHighScore)
        val btnAbout = findViewById<Button>(R.id.btnAbout)

        // Set click listeners
        btnPlay.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnHighScore.setOnClickListener {
            // Navigate to high score activity
        }

        btnAbout.setOnClickListener {
            // Navigate to about activity
        }
    }
}
