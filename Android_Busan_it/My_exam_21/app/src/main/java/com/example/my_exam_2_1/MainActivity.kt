package com.example.my_exam_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.my_exam_2_1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var v : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v = ActivityMainBinding.inflate(layoutInflater)
        setContentView(v.root)

        v.btnRandom.setOnClickListener {
            v.Num1.setText("${java.util.Random().nextInt(8) + 2}")
            v.Num2.setText("${java.util.Random().nextInt(8) + 2}")
        }

        v.btnSubmit.setOnClickListener {
            if(!((v.Num1.text.toString() == "" || v.Num2.text.toString() == null) || (v.Num2.text.toString() == "" || v.Num2.text.toString() == null) ||
                (v.result.text.toString() == "" || v.result.text.toString() == null))){
                val result = v.Num1.text.toString().toInt() * v.Num2.text.toString().toInt()
                if(result == v.result.text.toString().toInt()) {
                    Toast.makeText(this, "정답입니다!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "틀렸습니다!", Toast.LENGTH_SHORT).show()
                    v.tvresult1.setText("${v.Num1.text} X 1 = ${v.Num1.text.toString().toInt() * 1}")
                    v.tvresult2.setText("${v.Num1.text} X 2 = ${v.Num1.text.toString().toInt() * 2}")
                    v.tvresult3.setText("${v.Num1.text} X 3 = ${v.Num1.text.toString().toInt() * 3}")
                    v.tvresult4.setText("${v.Num1.text} X 4 = ${v.Num1.text.toString().toInt() * 4}")
                    v.tvresult5.setText("${v.Num1.text} X 5 = ${v.Num1.text.toString().toInt() * 5}")
                    v.tvresult6.setText("${v.Num1.text} X 6 = ${v.Num1.text.toString().toInt() * 6}")
                    v.tvresult7.setText("${v.Num1.text} X 7 = ${v.Num1.text.toString().toInt() * 7}")
                    v.tvresult8.setText("${v.Num1.text} X 8 = ${v.Num1.text.toString().toInt() * 8}")
                    v.tvresult9.setText("${v.Num1.text} X 9 = ${v.Num1.text.toString().toInt() * 9}")
                }
            } else {
                Toast.makeText(this, "빈칸을 확인해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}