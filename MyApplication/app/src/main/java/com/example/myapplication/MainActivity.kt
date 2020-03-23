package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countButton: Button = findViewById(R.id.count_up)
        rollButton.setOnClickListener{ rollDice() }
        countButton.setOnClickListener { countUp() }

    }
    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
        Toast.makeText(this, "button cliked",
            Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if (resultText.text.toString() == "Hello World!"){
            resultText.text = "1"
        } else {
            if (resultText.text.toString().toInt() < 6) {
                resultText.text = (resultText.text.toString().toInt() + 1).toString()
            }
        }
    }
}

