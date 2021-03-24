package com.example.myservice1_media1

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {

    lateinit var mp : MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        android.util.Log.i("서비스 테스트", "onCreate()")
    }

    override fun onDestroy() {
        mp.stop()
        android.util.Log.i("서비스 테스트", "onDestroy()")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        android.util.Log.i("서비스 테스트", "onStartCommand()")
        mp = MediaPlayer.create(this, R.raw.song1)
        mp.isLooping = true
        mp.start()
        return super.onStartCommand(intent, flags, startId)
    }


}