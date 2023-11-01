package com.example.splitapp;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val setupButton =findViewById<Button>(R.id.leftButton)
        val recognitionButton =findViewById<Button>(R.id.rightButton)


        setupButton.setOnClickListener {
            val setupIntent = Intent(this, SetupActivity::class.java)
            startActivity(setupIntent)
        }

        recognitionButton.setOnClickListener {
            val recognitionIntent = Intent(this, RecognitionActivity::class.java)
            startActivity(recognitionIntent)
        }
    }
}
