package com.example.myactivityintent1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        var button : Button = findViewById<Button>(R.id.btnMove1)
        var button2 : Button = findViewById<Button>(R.id.btnMove2)
        button.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            var intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}