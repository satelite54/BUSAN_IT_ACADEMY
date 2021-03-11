package com.example.mypractice_06_ex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.TimePicker
import androidx.core.view.children
import com.example.mypractice_06_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var selectYear = 0;
    var selectMonth = 0;
    var selectDay = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tPicker.visibility = View.INVISIBLE
        binding.calendarView1.visibility = View.INVISIBLE

        binding.rdoCal.setOnClickListener {
            binding.tPicker.visibility = View.INVISIBLE
            binding.calendarView1.visibility = View.VISIBLE
        }

        binding.rdoTime.setOnClickListener{
            binding.tPicker.visibility = View.VISIBLE
            binding.calendarView1.visibility = View.INVISIBLE
        }

        binding.btnStart.setOnClickListener{
            binding.chronometer1.base = SystemClock.elapsedRealtime()
            binding.chronometer1.start()
            binding.chronometer1.setTextColor(Color.RED)
        }

        binding.btnEnd.setOnClickListener{
            binding.chronometer1.stop()
            binding.chronometer1.setTextColor(Color.BLUE)

            binding.tvYear.text = selectYear.toString()
            binding.tvMonth.text = selectMonth.toString()
            binding.tvDay.text = selectDay.toString()

            binding.tvHour.text = binding.tPicker.currentHour.toString()
            binding.tvMinute.text = binding.tPicker.currentMinute.toString()
        }

        binding.calendarView1.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year;
            selectMonth = month + 1
            selectDay = dayOfMonth
        }
    }
}