package com.example.myinfomation

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var textView1 : TextView
    lateinit var textView2 : TextView
    lateinit var btn1 : Button

    lateinit var editText1 : EditText
    lateinit var editText2 : EditText
    lateinit var textView3 : TextView

    lateinit var view1 : View
    lateinit var view2 : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.tvName)
        textView2 = findViewById(R.id.tvEmail)
        btn1 = findViewById(R.id.button1)

        btn1.setOnClickListener {
            view1 = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_launcher_background)
            dlg.setView(view1)
            dlg.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
                editText1 = view1.findViewById<EditText>(R.id.dlgEdt1)
                editText2 = view1.findViewById<EditText>(R.id.dlgEdt2)

                textView1.text = editText1.text.toString()
                textView2.text = editText2.text.toString()
            })

            dlg.setNegativeButton("취소", { dialog, which ->
                var toast = Toast(this@MainActivity)
                view2 = View.inflate(this@MainActivity, R.layout.toast1, null)
                textView3 = view2.findViewById<TextView>(R.id.toastText1)
                textView3.text = "취소했습니다."
                toast.view = view2
                toast.show()
            })
            dlg.show()
        }
    }
}