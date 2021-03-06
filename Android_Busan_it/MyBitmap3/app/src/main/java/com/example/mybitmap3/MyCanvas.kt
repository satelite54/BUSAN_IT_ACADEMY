package com.example.mybitmap3

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class MyCanvas(context: Context) : View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var picture = BitmapFactory.decodeResource(resources,R.drawable.lena256)

        var picX = (this.width - picture.width) / 2f
        var picY = (this.height - picture.height) / 2f

        var paint = Paint()
        var bMask : BlurMaskFilter

        bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL)
        paint.maskFilter = bMask
        canvas!!.drawBitmap(picture, picX, picY, paint)

        bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.INNER)
        paint.maskFilter = bMask
        canvas!!.drawBitmap(picture, picX, picY, paint)

        bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.OUTER)
        paint.maskFilter = bMask
        canvas!!.drawBitmap(picture, picX, picY, paint)

        bMask = BlurMaskFilter(30f, BlurMaskFilter.Blur.SOLID)
        paint.maskFilter = bMask
        canvas!!.drawBitmap(picture, picX, picY, paint)

        picture.recycle()
    }
}

//class MyCanvas : View {
//    constructor(context: Context) {
//        super(context)
//    }
//}