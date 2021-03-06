package com.example.myactivityintent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rating1 : RatingBar
        var rating2 : RatingBar
        var rating3 : RatingBar
        var btnInc : Button
        var btnDec : Button

        rating1 = findViewById<RatingBar>(R.id.ratingBar1)
        rating2 = findViewById<RatingBar>(R.id.ratingBar2)
        rating3 = findViewById<RatingBar>(R.id.ratingBar3)
        btnInc = findViewById<Button>(R.id.btnInc)
        btnDec = findViewById<Button>(R.id.btnDec)

        btnInc.setOnClickListener {
            rating1.rating = rating1.rating + rating1.stepSize
            rating2.rating = rating2.rating + rating2.stepSize
            rating3.rating = rating3.rating + rating3.stepSize
        }


        btnDec.setOnClickListener {
            rating1.rating = rating1.rating - rating1.stepSize
            rating2.rating = rating2.rating - rating2.stepSize
            rating3.rating = rating3.rating - rating3.stepSize
        }
    }
}