package com.example.tablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal var numButtons = ArrayList<Button>(10)
    internal var btnResult = ArrayList<Button>(5)
    internal var numBtnIDs = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                                    R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                                    R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)
    internal var btnCalAray = arrayOf(R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5)

    internal lateinit var edit1 : EditText;
    internal lateinit var edit2 : EditText;
    internal lateinit var textResult : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit1 = findViewById(R.id.EditView)
        edit2 = findViewById(R.id.EditView2)

        textResult = findViewById(R.id.textView3)

        var num1 = "";
        var num2 = "";
        for(i in numBtnIDs.indices) {
            numButtons.add(findViewById<Button>(numBtnIDs[i]))
            numButtons[i].setOnClickListener {
                if(edit1.isFocused) {
                    num1 = edit1.text.toString() + numButtons[i].text.toString()
                    edit1.setText(num1)
                } else if (edit2.isFocused) {
                    num2 = edit2.text.toString() + numButtons[i].text.toString()
                    edit2.setText(num2)
                } else
                    Toast.makeText(applicationContext, "먼저 에디트텍스트 선택하세요", Toast.LENGTH_LONG).show()
            }
        }
        var Result = 0;
        for(i in btnCalAray.indices) {
            btnResult.add(findViewById<Button>(btnCalAray[i]))
            btnResult.get(i).setOnClickListener {
                var str = edit1.text.toString()
                Result = when(i) {
                            0 -> edit1.text.toString().toInt() + edit2.text.toString().toInt()
                            1 -> edit1.text.toString().toInt() - edit2.text.toString().toInt()
                            2 -> edit1.text.toString().toInt() * edit2.text.toString().toInt()
                            3 -> edit1.text.toString().toInt() / edit2.text.toString().toInt()
                            4 -> edit1.text.toString().toInt() % edit2.text.toString().toInt()
                            else -> 0
                        }
                textResult.setText(Result.toString())
            }
        }
    }
}