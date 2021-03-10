package com.example.mylayout_ex_03_liner_kotlin

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // 레이아웃 파라미터 정의
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                LinearLayout.LayoutParams.MATCH_PARENT)

        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL;
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0))

        var editText = EditText(this)
        editText.gravity = View.TEXT_ALIGNMENT_TEXT_START
        // id를 생성하지 않아도 UI 조작이 가능한데... 왜?
//        editText.id = ViewCompat.generateViewId()
        baseLayout.addView(editText);
        println(editText.id)

        var button = Button(this)
        button.setText("버튼입니다.")
        button.setBackgroundColor(Color.rgb(255,0,0))
        button.id = ViewCompat.generateViewId()
        baseLayout.addView(button)
        println(editText.id)

        var textView = TextView(this)
        textView.setTextColor(Color.rgb(0,0,255))
        textView.id = ViewCompat.generateViewId()
        baseLayout.addView(textView)
        // 뷰 메모리에 레이아웃 인플레이션
        setContentView(baseLayout, params)

        //코틀린은 findViewById로 Id를 연결 안해줘도 된단다. 왜?
//        editText = findViewById(editText.id)
//        button = findViewById(button.id)
//        textView = findViewById(textView.id)
        println(editText.id)
        println(button.id)
        println(textView.id)
        button.setOnClickListener {
            textView.setText(editText.text.toString())
        }
    }
}