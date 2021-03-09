package com.example.kotlinreminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    lateinit var edit1 : EditText
//    lateinit var edit2 : EditText
//    lateinit var btnAdd : Button
//    lateinit var btnSub : Button
//    lateinit var btnMul : Button
//    lateinit var btnDiv : Button
//    lateinit var textResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var edit1 : EditText
        lateinit var edit2 : EditText
        lateinit var btnAdd : Button
        lateinit var btnSub : Button
        lateinit var btnMul : Button
        lateinit var btnDiv : Button
        lateinit var btnPer : Button
        lateinit var textResult : TextView

        edit1 = findViewById(R.id.EditView)
        edit2 = findViewById(R.id.EditView2)
        btnAdd = findViewById<Button>(R.id.button)
        btnSub = findViewById<Button>(R.id.button2)
        btnMul = findViewById(R.id.button3)
        btnDiv = findViewById(R.id.button4)
        btnPer = findViewById(R.id.button5)
        textResult = findViewById(R.id.textView3)

        callListener(btnAdd, edit1, edit2, '+', textResult)
        callListener(btnSub, edit1, edit2, '-', textResult)
        callListener(btnMul, edit1, edit2, '*', textResult)
        callListener(btnDiv, edit1, edit2, '/', textResult)
        callListener(btnPer, edit1, edit2, '%', textResult)
    }

    private fun callListener(btn : Button, edit1: EditText, edit2: EditText, c: Char, result: TextView) {
        btn.setOnClickListener { v ->
            var str1 = edit1.text.toString()
            var str2 = edit2.text.toString()

            if(str1 == "" || str2 == "") {
                makeToast("빈 칸을 채워주세요!")
                return@setOnClickListener
            }

            var a = str1.toInt()
            var b = str2.toInt()
            var cal = when(c) {
                '+' -> a + b
                '-' -> a - b
                '*' -> a * b
                '/' -> a / b
                '%' -> a % b
                else -> 0
            }
            result.text = cal.toString()
        }
    }

    private fun makeToast(str : String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}