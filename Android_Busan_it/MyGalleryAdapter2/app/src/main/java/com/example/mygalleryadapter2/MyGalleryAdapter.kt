package com.example.mygalleryadapter2

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView

class MyGalleryAdapter(var context: Context, var intAryID : Array<Int>, var imgView : ImageView) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imageview = ImageView(context)
        imageview.layoutParams = Gallery.LayoutParams(200, 300)
        imageview.scaleType = ImageView.ScaleType.FIT_CENTER
        imageview.setImageResource(intAryID[position])

        imgView.setOnTouchListener { v, event ->
            var ivPoster = v.findViewById<ImageView>(R.id.ivPoster)
            ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
            ivPoster.setImageResource(intAryID[position - 1])
            false
        }

        return imageview
    }

    override fun getCount(): Int {
        return intAryID.size
    }

    override fun getItem(position: Int): Any {
        return 0;
    }

    override fun getItemId(position: Int): Long {
        return 0;
    }
}