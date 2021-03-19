package com.example.mybitmap4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.EmbossMaskFilter
import android.graphics.Paint
import android.view.View

class MyCanvas(context: Context) : View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var cenX = this.width / 2f
        var cenY = this.height / 2f

        var paint = Paint()
        paint.color = Color.GRAY

        var eMask : EmbossMaskFilter

        eMask = EmbossMaskFilter(floatArrayOf(3f, 3f, 3f), 0.5f, 5f, 10f)

        paint.maskFilter = eMask
        canvas!!.drawCircle(cenX, cenY, 150f, paint)
    }
}