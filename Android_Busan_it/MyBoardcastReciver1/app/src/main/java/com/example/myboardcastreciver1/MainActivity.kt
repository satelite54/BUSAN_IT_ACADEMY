package com.example.myboardcastreciver1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var ivBattery : ImageView
    lateinit var edtBattery : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivBattery = findViewById<ImageView>(R.id.ivBattary)
        edtBattery = findViewById<EditText>(R.id.edtBattery)

    }

    var br : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var action = intent!!.action
            if (action == Intent.ACTION_BATTERY_CHANGED) {
                var remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                edtBattery.setText("현재 충전량 : $remain\n")

                when(remain) {
                    in 90..100 -> {
                        ivBattery.setImageResource(R.drawable.battery_100)
                    }
                    in 70..89 -> {
                        ivBattery.setImageResource(R.drawable.battery_80)
                    }
                    in 50..69 -> {
                        ivBattery.setImageResource(R.drawable.battery_60)
                    }
                    in 10..49 -> {
                        ivBattery.setImageResource(R.drawable.battery_20)
                    }
                    in 0..9 -> {
                        ivBattery.setImageResource(R.drawable.battery_0)
                    }
                }

                var plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)

                when (plug) {
                    0 -> edtBattery.append("전원 연결 : 안됨")
                    BatteryManager.BATTERY_PLUGGED_AC -> edtBattery.append("전원 연결 : 어댑터 연결됨")
                    BatteryManager.BATTERY_PLUGGED_USB -> edtBattery.append("USB 연결됨")
                }

            }
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(br)
    }

    override fun onResume() {
        super.onResume()
        var iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(br, iFilter)
    }
}