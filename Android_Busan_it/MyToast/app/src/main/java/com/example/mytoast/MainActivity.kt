package com.example.mytoast

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tMsg = Toast.makeText(this, "토스트 연습", Toast.LENGTH_SHORT)

        var display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        var xOffset = (Math.random() * display.width).toInt()
        var yOffset = (Math.random() * display.height).toInt()

        tMsg.setGravity(Gravity.TOP or Gravity.LEFT , xOffset, yOffset)

        btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            tMsg.show()
        }
    }
}