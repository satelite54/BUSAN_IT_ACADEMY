package com.example.mygrapic

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(그리는놈(this))
    }

    private class 그리는놈(컨텍스트: Context) : View(컨텍스트) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            val 페인트 = Paint()
            var 켄버스 = canvas

            페인트.isAntiAlias = true
            페인트.color = Color.GREEN
            켄버스!!.drawLine(10f, 10f, 300f, 10f, 페인트)

            페인트.color = Color.BLUE
            페인트.strokeWidth = 5f
            켄버스!!.drawLine(10f, 30f, 300f, 30f, 페인트)

            페인트.color = Color.RED
            페인트.strokeWidth = 0f

            페인트.style = Paint.Style.FILL
            val 사각형1 = Rect(10,50,10 + 100, 50 + 100)
            canvas!!.drawRect(사각형1, 페인트)

            페인트.style = Paint.Style.STROKE
            val 사각형2 = Rect(130,50,130 + 100, 50 + 100)
            canvas!!.drawRect(사각형2, 페인트)

            var 사각형3 = RectF(250f, 50f, 250f + 100f, 50f + 100f)
            canvas!!.drawRoundRect(사각형3, 20f, 20f, 페인트)

            canvas!!.drawCircle(60f, 200f, 50f, 페인트)
            페인트.strokeWidth = 5f

            val path1= Path()
            path1.moveTo(10f, 290f)
            path1.lineTo(10f + 50f, 290f + 50f)
            path1.lineTo(10f + 100f, 290f)
            path1.lineTo(10f + 200f, 290f)
            켄버스.drawText("안드로이드", 10f, 390f, 페인트)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                // 손가락 화면을 누르기 시작했을 때 할 일
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {

            }
            MotionEvent.ACTION_CANCEL -> {

            }
        }
        return true
    }
}