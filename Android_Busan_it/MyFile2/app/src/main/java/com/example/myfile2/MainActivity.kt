package com.example.myfile2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.io.FileInputStream
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var dp : DatePicker
    lateinit var ediDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileNmae : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 일기장"

        dp = findViewById<DatePicker>(R.id.datePicker1)
        ediDiary = findViewById<EditText>(R.id.edtDiary)
        btnWrite = findViewById<Button>(R.id.btnWrite)

        btnWrite = findViewById<Button>(R.id.btnWrite)

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        dp.init(cYear, cMonth, cDay) {
            view, year, monthOfYear, dayOfMonth ->
            fileNmae = (Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth) + ".txt")
            var str = readDiary(fileNmae)
            ediDiary.setText(str)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            var outFs = openFileOutput(fileNmae, Context.MODE_PRIVATE)
            var str = ediDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext, "$fileNmae 이 저장됨", Toast.LENGTH_SHORT).show()
        }


    }

    fun readDiary(fName: String) : String? {

        var diaryStr : String? = null
        var inFs : FileInputStream
        try {
            inFs = openFileInput(fName)
            var txt = ByteArray(500)
            inFs.read(txt)
            inFs.close()
            diaryStr = txt.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정하기"
        } catch (e: IOException) {
            ediDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }
        return diaryStr
    }
}