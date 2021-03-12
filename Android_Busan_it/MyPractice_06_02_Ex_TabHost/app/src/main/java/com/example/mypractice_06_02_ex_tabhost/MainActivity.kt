package com.example.mypractice_06_02_ex_tabhost

import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypractice_06_02_ex_tabhost.databinding.ActivityMainBinding

@Suppress("deprecation")
class MainActivity : TabActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var tabHost = this.tabHost
        var tabdog = tabHost.newTabSpec("DOG").setIndicator("개")
        tabdog.setContent(R.id.dog)
        tabHost.addTab(tabdog)

        var tabcat = tabHost.newTabSpec("CAT").setIndicator("고양이")
        tabcat.setContent(R.id.cat)
        tabHost.addTab(tabcat)

        var tabrabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼")
        tabrabbit.setContent(R.id.raddit)
        tabHost.addTab(tabrabbit)
        
        var tabhorse = tabHost.newTabSpec("HORSE").setIndicator("말")
        tabhorse.setContent(R.id.horse)
        tabHost.addTab(tabhorse)

        tabHost.currentTab = 0

        binding.dog.setImageResource(R.drawable.dog)
        binding.cat.setImageResource(R.drawable.cat)
        binding.raddit.setImageResource(R.drawable.rabbit)
        binding.horse.setImageResource(R.drawable.img)
    }
}