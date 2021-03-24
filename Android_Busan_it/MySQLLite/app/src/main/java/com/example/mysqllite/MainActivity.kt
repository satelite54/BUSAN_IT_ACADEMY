package com.example.mysqllite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var myHelper : myDBHelper
    lateinit var edtName: EditText
    lateinit var edtNumber : EditText
    lateinit var edtNameResult : EditText
    lateinit var edtNumberResult : EditText
    lateinit var btnInit : Button
    lateinit var btnInsert : Button
    lateinit var btnSelect : Button
    lateinit var btnUpdate : Button
    lateinit var btnDelete : Button
    lateinit var sqlDB : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "가수 그룹 관리 DB"

        edtName = findViewById<EditText>(R.id.editName)
        edtNumber = findViewById<EditText>(R.id.editName2)
        edtNameResult = findViewById<EditText>(R.id.edtNameResult)
        edtNumberResult = findViewById<EditText>(R.id.edtNumberResult)

        btnInit = findViewById<Button>(R.id.buttonInit)
        btnInsert = findViewById<Button>(R.id.buttonInsert)
        btnSelect = findViewById<Button>(R.id.buttonSelect)
        btnUpdate = findViewById<Button>(R.id.buttonUpdate)
        btnDelete = findViewById<Button>(R.id.buttonDelete)

        myHelper = myDBHelper(this)

        btnInit.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2)
            btnSelect.callOnClick()
            sqlDB.close()
        }

        btnInsert.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + edtName.text.toString() + "' , " + edtNumber.text.toString() + ");")
            sqlDB.close()
            btnSelect.callOnClick()
            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()
        }

        btnSelect.setOnClickListener {
            sqlDB = myHelper.readableDatabase
            var cursor : Cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null)

            var strNames = "그룹이름" + "\r\n" + "--------" + "\r\n"
            var strNumbers = "인원" + "\r\n" + "--------" + "\r\n"

            while (cursor.moveToNext()) {
                strNames += cursor.getString(0) + "\r\n"
                strNumbers += cursor.getString(1) + "\r\n"
            }

            edtNameResult.setText(strNames)
            edtNumberResult.setText(strNumbers)

            cursor.close()
            sqlDB.close()
        }
        btnUpdate.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("UPDATE groupTBL SET gNumber = '${edtNumber.text}' WHERE gName = '${edtName.text}';")
            sqlDB.close()
            btnSelect.callOnClick()
            Toast.makeText(this, "수정됨", Toast.LENGTH_LONG).show()
        }


        btnDelete.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("Delete FROM groupTBL WHERE gName = '${edtName.text}';")
            sqlDB.close()
            btnSelect.callOnClick()
            Toast.makeText(this, "삭제됨", Toast.LENGTH_LONG).show()
        }
    }
}