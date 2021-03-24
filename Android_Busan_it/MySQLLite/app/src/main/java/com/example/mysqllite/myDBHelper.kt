package com.example.mysqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY, gNumber INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS groupTBL")
        onCreate(db)
    }
}