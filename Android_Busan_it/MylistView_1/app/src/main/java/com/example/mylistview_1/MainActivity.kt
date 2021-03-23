package com.example.mylistview_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var context : Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        title = "그리드뷰 영화 포스터"

        var gv = findViewById<View>(R.id.gridView1) as GridView
        var aAdapter = MyGridAdapter(this)
        gv.adapter = aAdapter
    }
}