package com.example.mybitmap

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.View

class MyGraphicView
    (context: Context) : View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var picture = BitmapFactory.decodeResource(resources, R.drawable.jeju14)
        var picX = (this.width - picture.width) / 2f
        var picY = (this.height - picture.height / 2f)
        canvas!!.drawBitmap(picture, picX, picY, null)

        picture.recycle()
    }
}