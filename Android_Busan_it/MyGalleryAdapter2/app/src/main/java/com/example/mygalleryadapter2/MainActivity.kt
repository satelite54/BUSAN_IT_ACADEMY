package com.example.mygalleryadapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Gallery
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var posterID = arrayOf(R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
            R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
            R.drawable.mov17, R.drawable.mov18, R.drawable.mov19,
            R.drawable.mov20, R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
            R.drawable.mov24, R.drawable.mov25, R.drawable.mov26,
            R.drawable.mov27, R.drawable.mov28, R.drawable.mov29,
            R.drawable.mov30, R.drawable.mov31, R.drawable.mov32, R.drawable.mov33,
            R.drawable.mov34, R.drawable.mov35, R.drawable.mov36,
            R.drawable.mov37, R.drawable.mov38, R.drawable.mov39,
            R.drawable.mov40)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gallery = findViewById<Gallery>(R.id.gallery1)
        var imgview = findViewById<ImageView>(R.id.ivPoster)
        var galAdapter = MyGalleryAdapter(this, posterID, imgview)
        gallery.adapter = galAdapter

        var myLis = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}