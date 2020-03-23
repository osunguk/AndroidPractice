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
        val resultImage2: ImageView = findViewById(R.id.dice_image2)
        val randomInt = (1..6).random()
        val randomInt2 = (1..6).random()

        val drawbleResource = pickImage(randomInt)
        val drawbleResource2 = pickImage(randomInt2)

        resultImage.setImageResource(drawbleResource)
        resultImage2.setImageResource(drawbleResource2)

        resultText.text = randomInt.toString() + " & " + randomInt2.toString()
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
        val resultImage2: ImageView = findViewById(R.id.dice_image2)

        if (resultText.text.toString() == "Hello World!"){
            resultText.text = "1 & 1"
            resultImage.setImageResource(R.drawable.dice_1)
            resultImage2.setImageResource(R.drawable.dice_1)

        } else {
            var text = ""
            var text2 = ""
            val numbers = resultText.text.toString().split(" & ")
            if (numbers[0].toInt() < 6) {
                val drawbleResource = pickImage(numbers[0].toInt()+1)
                resultImage.setImageResource(drawbleResource)
                text = (numbers[0].toInt()+1).toString() + " & "
            } else {
                text = "6 & "
            }
            if (numbers[1].toInt() < 6) {
                val drawbleResource2 = pickImage(numbers[1].toInt()+1)
                resultImage2.setImageResource(drawbleResource2)
                text2 = (numbers[1].toInt()+1).toString()
            } else {
                text2 = "6"
            }
            resultText.text = text + text2
        }
    }

    private fun clear() {
        val resultText: TextView = findViewById(R.id.result_text)
        val resultImage: ImageView = findViewById(R.id.dice_image)
        val resultImage2: ImageView = findViewById(R.id.dice_image2)


        resultText.text = "Hello World!"
        resultImage.setImageResource(R.drawable.empty_dice)
        resultImage2.setImageResource(R.drawable.empty_dice)
    }
}

