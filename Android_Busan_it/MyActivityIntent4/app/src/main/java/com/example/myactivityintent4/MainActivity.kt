package com.example.myactivityintent4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)
            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("Num1", edtNum1.text.toString().toInt())
            intent.putExtra("Num2", edtNum2.text.toString().toInt())
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var hap = data!!.getIntExtra("Hap", 0)
        Toast.makeText(applicationContext, "합계 : ${hap}", Toast.LENGTH_SHORT).show()
    }
}