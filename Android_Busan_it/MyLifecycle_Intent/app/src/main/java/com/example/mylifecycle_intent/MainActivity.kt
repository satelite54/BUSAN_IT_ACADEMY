package com.example.mylifecycle_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Call : Button
    lateinit var End : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        android.util.Log.i("액티비티 테스트","onCreate()")
        Call = findViewById<Button>(R.id.Call)
        End = findViewById<Button>(R.id.End)

        Call.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"))
            startActivity(intent)
        }

        End.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        android.util.Log.i("액티비티 테스트","onStart()")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        android.util.Log.i("액티비티 테스트", "onCreate()")
    }

    override fun onResume() {
        super.onResume()
        android.util.Log.i("액티비티 테스트", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        android.util.Log.i("액티비티 테스트", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.i("액티비티 테스트", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.i("액티비티 테스트" ,"onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        android.util.Log.i("액티비티 테스트", "onRestart()")
    }

    var dw = funInterface {
        System.out.println(121213213)
    }
}