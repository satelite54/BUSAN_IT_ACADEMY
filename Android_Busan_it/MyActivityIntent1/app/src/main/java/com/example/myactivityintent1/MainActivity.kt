package com.example.myactivityintent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnCreateActivity : Button = findViewById<Button>(R.id.btnNewActivity)

        btnCreateActivity.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent);
        }
    }
}