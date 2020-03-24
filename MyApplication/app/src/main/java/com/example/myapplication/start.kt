package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class start : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)


        val diceRoll: Button = findViewById(R.id.button1)
        diceRoll.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val scrollView: Button = findViewById(R.id.button2)
        scrollView.setOnClickListener {
            val intent = Intent( this, Main2Activity::class.java)
            startActivity(intent)
        }

        val inputText: Button = findViewById(R.id.button3)
        inputText.setOnClickListener {
            val intent = Intent( this, InputText::class.java)
            startActivity(intent)
        }
    }


}