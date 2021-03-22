package com.example.myactivityintent5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    lateinit var btnReturn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        var num1 = intent.getIntExtra("num1", 0)
        var num2 = intent.getIntExtra("num2", 0)
        var operator = intent.getCharExtra("operator", '0')
        var result = 0;
        btnReturn = findViewById<Button>(R.id.btnBackMain)

        btnReturn.setOnClickListener {
            result = when(operator) {
                        '+' -> num1 + num2
                        '-' -> num1 - num2
                        '*' -> num1 * num2
                        '/' -> num1 / num2
                        else -> 0
                    }
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", result)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}