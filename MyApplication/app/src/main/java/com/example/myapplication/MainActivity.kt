package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val clearButton: Button = findViewById(R.id.clear_data)
        rollButton.setOnClickListener{ rollDice() }
        countButton.setOnClickListener { countUp() }
        clearButton.setOnClickListener { clear() }

    }
    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val resultImage: ImageView = findViewById(R.id.dice_image)
        val randomInt = (1..6).random()

        val drawbleResource = pickImage(randomInt)

        resultImage.setImageResource(drawbleResource)

        resultText.text = randomInt.toString()
        Toast.makeText(this, "button cliked",
            Toast.LENGTH_SHORT).show()
    }

    fun pickImage(num: Int): Int {
        return when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
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
                val drawbleResource = pickImage(num)
                resultImage.setImageResource(drawbleResource)
            }
        }
    }

    private fun clear() {
        val resultText: TextView = findViewById(R.id.result_text)
        val resultImage: ImageView = findViewById(R.id.dice_image)

        resultText.text = "Hello World!"
        resultImage.setImageResource(R.drawable.empty_dice)
    }
}

