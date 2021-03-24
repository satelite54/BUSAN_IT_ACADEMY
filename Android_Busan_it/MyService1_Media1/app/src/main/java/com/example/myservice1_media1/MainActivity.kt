package com.example.myservice1_media1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var  soundIntent : Intent
    lateinit var btnStart : Button
    lateinit var btnStop : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        title = "서비스 테스트 예제"

        soundIntent = Intent(this, MyService::class.java)
        btnStart = findViewById<Button>(R.id.serviceStart)
        btnStop = findViewById<Button>(R.id.serviceStop)

        btnStart.setOnClickListener {
            startService(soundIntent)
            android.util.Log.i("서비스 테스트", "StartService()")
        }

        btnStop.setOnClickListener {
            stopService(soundIntent)
            android.util.Log.i("서비스 테스트", "StopService()")
        }
    }
}