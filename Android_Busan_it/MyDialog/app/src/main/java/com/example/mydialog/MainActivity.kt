package com.example.mydialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = findViewById<Button>(R.id.button1)
        var list = arrayListOf<String>()
        button1.setOnClickListener {
            var versionArray = arrayOf("오레오", "파이", "큐(10)")
            var checkArray = booleanArrayOf(true, false ,false)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("좋아하는 버전은?")
            dlg.setIcon(R.mipmap.ic_launcher)

            dlg.setMultiChoiceItems(versionArray, checkArray) {
                dialog, which, isChecked ->

                var dwdw : Button? = null
            }
            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }
    }
}