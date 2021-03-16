package com.example.myxmlcontext

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout : LinearLayout
    lateinit var button1 : Button
    lateinit var button2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "배경색 바꾸기(컨택스트 메뉴)"
        baseLayout = findViewById<LinearLayout>(R.id.baseLayout) as LinearLayout
        button1 = findViewById<Button>(R.id.btn1) as Button
        registerForContextMenu(button1)
        button2 = findViewById<Button>(R.id.btn2) as Button
        registerForContextMenu(button2)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v!!.id == R.id.btn1) {
            menu!!.add(0, 1, 0, "배경색 (파랑)")
            menu!!.add(0, 2, 0, "배경색 (빨강)")
            menu!!.add(0, 3, 0, "배경색 (초록)")
        }
        if(v!!.id == R.id.btn2) {
            menu!!.add(0, 4, 0, "회전")
            menu!!.add(0, 5, 0, "확대")
        }
//        var mInflater = this.menuInflater
//        if(v === button1) {
//            menu!!.setHeaderTitle("배경색 변경")
//            mInflater.inflate(R.menu.menu1, menu)
//        }
//        if(v === button2) {
//            mInflater.inflate(R.menu.menu2, menu)
//        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when(item.itemId) {
//            R.id.itemBlue -> {
//                baseLayout.setBackgroundColor(Color.BLUE)
//            }
//            R.id.itemRed -> {
//                baseLayout.setBackgroundColor(Color.RED)
//            }
//            R.id.itemGreen -> {
//                baseLayout.setBackgroundColor(Color.GREEN)
//            }
//            R.id.subRotate -> {
//                button2.rotation += 180f
//            }
//            R.id.subSize -> {
//                button2.width += 20
//                button2.height += 20
//            }
            1 -> {
                baseLayout.setBackgroundColor(Color.BLUE)
            }
            2 -> {
                baseLayout.setBackgroundColor(Color.RED)
            }
            3 -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            4 -> {
                button2.rotation += 180f
            }
            5 -> {
                button2.width += 20
                button2.height += 20
            }
        }
        return true
    }
}