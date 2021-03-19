package com.example.mybitmap

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.mybitmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    lateinit var graphicView : MyCanvas

    companion object {
        var sX = 1f
        var sY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        title = "미니 포토샵"

        var pictureLayout = bind.pictureLayout
        graphicView = MyCanvas(this)
        pictureLayout.addView(graphicView)
        clickIcons()
    }

    private fun clickIcons() {
        bind.ibZoomin.setOnClickListener {
            sX = sX + 0.2f
            sY = sY + 0.2f
            graphicView.invalidate()
        }

        bind.ibZoomout.setOnClickListener {
            sX = sX - 0.2f
            sY = sY - 0.2f
            graphicView.invalidate()
        }

        bind.ibRotate.setOnClickListener {
            angle = angle + 20
            graphicView.invalidate()
        }

        bind.ibBright.setOnClickListener {
            color = color + 0.2f
            graphicView.invalidate()
        }
        bind.ibDark.setOnClickListener {
            color = color - 0.2f
            graphicView.invalidate()
        }
        bind.ibGray.setOnClickListener {
            if (satur == 0f)
                satur = 1f
            else
                satur = 0f
            graphicView.invalidate()
        }
    }

    class MyCanvas(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            var picture = BitmapFactory.decodeResource(resources, R.drawable.renoir09)
            var picX = (this.width - picture.width) / 2f
            var picY = (this.height - picture.height) / 2f

            var cenX = this.width / 2f
            var cenY = this.height / 2f
            canvas!!.scale(sX, sY, cenX, cenY)
            canvas!!.rotate(angle, cenX, cenY)

            var paint = Paint()
            var array = floatArrayOf( color, 0f, 0f, 0f, 0f,
                                        0f, color, 0f, 0f, 0f,
                                        0f, 0f, color, 0f, 0f,
                                        0f, 0f, 0f, 1f, 0f)
            var cm = ColorMatrix(array)
            if(satur == 0f)
                cm.setSaturation(satur)
            paint.colorFilter = ColorMatrixColorFilter(cm)
            canvas.drawBitmap(picture, picX, picY, paint)
            picture.recycle()
        }
    }
}