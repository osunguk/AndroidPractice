package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        findViewById<ImageView>(R.id.email_refresh).setOnClickListener {
            refreshEmail()
        }
        findViewById<ImageView>(R.id.pw_refresh).setOnClickListener {
            refreshPassWord()
        }

        findViewById<Button>(R.id.login_button).setOnClickListener {
            onClickLoginButton()
        }

        val emailData = findViewById<EditText>(R.id.email_input)
        val pwData = findViewById<EditText>(R.id.pw_input)
        val pwVaildationCheck = findViewById<TextView>(R.id.pw_valid_check)

        pwData.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password: Int = s.toString().length
                if (password == 0) {
                    pwVaildationCheck.visibility = View.GONE
                }
                else if (password < 6 || password > 12) {
                    pwVaildationCheck.visibility = View.VISIBLE
                } else {
                    pwVaildationCheck.visibility = View.GONE
                }
            }
        })
    }

    fun pageBackMove(view: View) {
        onBackPressed()
    }

    private fun refreshEmail() {
        val emailData = findViewById<EditText>(R.id.email_input)
        emailData.text = null
    }

    private fun refreshPassWord() {
        val pwData = findViewById<EditText>(R.id.pw_input)
        pwData.text = null
    }

    private fun vaildationCheck() {

    }

    private fun onClickLoginButton() {
        val emailData = findViewById<EditText>(R.id.email_input)
        val pwData = findViewById<EditText>(R.id.pw_input)
        val checkInputData = findViewById<TextView>(R.id.check_input_data)
        Log.d("tag","check")

        if( emailData.text.isEmpty() || pwData.text.isEmpty()){
            checkInputData.visibility = View.VISIBLE
        } else {
            checkInputData.visibility = View.GONE
        }
    }
}