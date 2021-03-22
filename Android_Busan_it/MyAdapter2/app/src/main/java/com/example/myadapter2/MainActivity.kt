package com.example.myadapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var btnAdd : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var midList = ArrayList<String>()
        editText = findViewById<EditText>(R.id.edtItem)
        btnAdd = findViewById<Button>(R.id.btnAdd)

        var list = findViewById<ListView>(R.id.listView1)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, midList)
        list.adapter = adapter

        btnAdd.setOnClickListener {
            midList.add(editText.text.toString())
            adapter.notifyDataSetChanged()
        }

        list.setOnItemClickListener { parent, view, position, id ->
            midList.removeAt(position)
            adapter.notifyDataSetChanged()
            false
        }
    }
}