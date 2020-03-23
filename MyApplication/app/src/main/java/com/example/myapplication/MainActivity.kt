package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
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
        val resultImage: ImageView = findViewById(R.id.dice_image)
        val randomInt = (1..6).random()

        val drawbleResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        resultImage.setImageResource(drawbleResource)

        resultText.text = randomInt.toString()
        Toast.makeText(this, "button cliked",
            Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val resultImage: ImageView = findViewById(R.id.dice_image)

        if (resultText.text.toString() == "Hello World!"){
            resultText.text = "1"
            resultImage.setImageResource(R.drawable.dice_1)
        } else {
            if (resultText.text.toString().toInt() < 6) {
                val num: Int = resultText.text.toString().toInt() + 1
                resultText.text = num.toString()
                val drawbleResource = when (num) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
                resultImage.setImageResource(drawbleResource)
            }
        }
    }
}

