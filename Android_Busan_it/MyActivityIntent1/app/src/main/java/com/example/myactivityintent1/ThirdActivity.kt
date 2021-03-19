package com.example.myactivityintent1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class ThirdActivity : Activity() {

    lateinit var radiogroup : RadioGroup
    lateinit var btnOpenActivity : Button
    lateinit var radio1 : RadioButton
    lateinit var radio2 : RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thrid)

        btnOpenActivity = findViewById<Button>(R.id.btnThirdActivity)
        radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        radio1 = findViewById<RadioButton>(R.id.radio1)
        radio2 = findViewById<RadioButton>(R.id.radio2)

        btnOpenActivity.setOnClickListener {
            var intent : Intent
            when(radiogroup.checkedRadioButtonId) {
                R.id.radio1 -> {
                    intent = Intent(this, MainActivity::class.java)
                }
                R.id.radio2 -> {
                    intent = Intent(this, SecondActivity::class.java)
                }
                else -> {
                    intent = Intent(this, ThirdActivity::class.java)
                }
            }
            startActivity(intent)
        }
    }
}