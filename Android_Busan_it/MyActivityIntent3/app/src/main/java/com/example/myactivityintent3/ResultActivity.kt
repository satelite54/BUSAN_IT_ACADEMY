package com.example.myactivityintent3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        title = "투표 결과"

        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName!!.size)

        var tvID = arrayOf(R.id.pic1text, R.id.pic2text, R.id.pic3text, R.id.pic4text, R.id.pic5text,
            R.id.pic6text, R.id.pic7text, R.id.pic8text, R.id.pic9text)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
            R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)

        for(i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }

        for(i in voteResult.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.rating = voteResult[i].toFloat()
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}