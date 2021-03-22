package com.example.myactivityintent5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myactivityintent5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var v : ActivityMainBinding
    var operator : Char = '\u0000'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        v = ActivityMainBinding.inflate(layoutInflater)
        var view = v.root
        setContentView(view)

        v.btnNewActivity.setOnClickListener {

            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("num1", v.num1.text.toString().toInt())
            intent.putExtra("num2", v.num2.text.toString().toInt())
            intent.putExtra("operator", operator)
            startActivityForResult(intent, 0)
        }

        v.rGroup.setOnCheckedChangeListener { radioGroup, radiobtnId ->
            when(radiobtnId) {
               R.id.radio1 -> {
                   operator = '+'
               }
                R.id.radio2 -> {
                    operator = '-'
                }
                R.id.radio3 -> {
                    operator = '*'
                }
                R.id.radio4 -> {
                    operator = '/'
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(Activity.RESULT_OK == resultCode) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "결과 : ${hap}", Toast.LENGTH_SHORT).show()
        }
    }
}