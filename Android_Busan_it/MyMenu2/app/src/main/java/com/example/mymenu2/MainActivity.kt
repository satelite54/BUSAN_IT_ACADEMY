package com.example.mymenu2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {


    lateinit var editText : EditText
    lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메뉴로 회전하기"
        imageView = findViewById<ImageView>(R.id.imageView1)
        editText = findViewById<EditText>(R.id.Edit1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.Rotate -> {
                var angle = editText.text.toString().toInt()
                imageView.rotation += angle
                return true
            }
            R.id.item1 -> {
                imageView.setImageResource(R.drawable.cat)
                item.setChecked(true)
                return true
            }
            R.id.item2 -> {
                imageView.setImageResource(R.drawable.dog)
                item.setChecked(true)
                return true
            }
            R.id.item3 -> {
                imageView.setImageResource(R.drawable.rabbit)
                item.setChecked(true)
                return true
            }
        }
        return false
    }

}