package com.example.mypractive_06_01_ex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mypractive_06_01_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var selectYear = 0;
    var selectMonth = 0;
    var selectDay = 0;
    var selectHour = 0;
    var selectMin = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tPicker.visibility = View.INVISIBLE
        binding.DatePicker.visibility = View.INVISIBLE

        binding.rdoCal.setOnClickListener {
            binding.tPicker.visibility = View.INVISIBLE
            binding.DatePicker.visibility = View.VISIBLE
        }

        binding.rdoTime.setOnClickListener{
            binding.tPicker.visibility = View.VISIBLE
            binding.DatePicker.visibility = View.INVISIBLE
        }

        binding.tvYear.setOnLongClickListener {
            binding.tvYear.setText(selectYear.toString());
            binding.tvMonth.setText(selectMonth.toString());
            binding.tvDay.setText(selectDay.toString());
            binding.tvDay.setText(selectDay.toString());
            binding.tvDay.setText(selectDay.toString());

            binding.tvHour.setText(selectHour.toString());
            binding.tvMinute.setText(selectMin.toString());
            false
        }

        binding.DatePicker.setOnDateChangedListener { datePicker, year, month, dayOfMonth ->
            selectYear = year;
            selectMonth = month + 1
            selectDay = dayOfMonth
        }

        binding.tPicker.setOnTimeChangedListener { timePicker, i, i2 ->
            selectHour = i;
            selectMin = i2;
        }
    }
}