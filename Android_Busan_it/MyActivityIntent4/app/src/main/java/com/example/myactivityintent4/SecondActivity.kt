package com.example.myactivityintent4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        title = "Second 액티비디"

        var intent = getIntent()
        var button: Button = findViewById<Button>(R.id.btnReturn)

        button.setOnClickListener {
            var hap = intent.extras!!.getInt("Num1") + intent.extras!!.getInt("Num2")
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hap)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}