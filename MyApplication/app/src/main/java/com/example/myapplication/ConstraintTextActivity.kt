package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityConstraintTestBinding


class ConstraintTextActivity: AppCompatActivity() {
    private lateinit var binding: ActivityConstraintTestBinding
    private var myName: Myname = Myname("Alekc Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_test)

        setListeners()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_constraint_test)
        binding.myName = myName
//        // 바인딩을 이용하면 코드가 직관적이고 간결하게 바뀐다
          // 기존의 findViewById는 작동이 안되는 듯하다
//        // findViewById<TextView>(R.id.textView4) ==> binding.textView4
//        binding.bindingTest.setOnClickListener {
//            binding.bindingTest.text = "change text"
//        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.textView4)
        val boxTwoText = findViewById<TextView>(R.id.textView5)
        val boxThreeText = findViewById<TextView>(R.id.textView6)
        val boxFourText = findViewById<TextView>(R.id.textView7)
        val boxFiveText = findViewById<TextView>(R.id.textView8)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootConstraintLayout)
        for (item in clickableViews) {
            item.setOnClickListener{ makeColored(it) }
        }

        val clickableImages: List<View> =
            listOf(imageView, imageView2, imageView3)
        for (item in clickableImages){
            item.setOnClickListener{ makeImaged(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.textView4 -> view.setBackgroundColor(Color.DKGRAY)
            R.id.textView5 -> view.setBackgroundColor(Color.GRAY)
            R.id.textView6 -> view.setBackgroundColor(Color.BLUE)
            R.id.textView7 -> view.setBackgroundColor(Color.MAGENTA)
            R.id.textView8 -> view.setBackgroundColor(Color.BLUE)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun makeImaged(view: View) {
        when (view.id){
            R.id.imageView -> view.setBackgroundResource(R.drawable.dice_1)
            R.id.imageView2 -> view.setBackgroundResource(R.drawable.dice_2)
            R.id.imageView3 -> view.setBackgroundResource(R.drawable.dice_3)
        }
    }
}