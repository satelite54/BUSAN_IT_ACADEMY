package com.example.imageviewbutton

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : Switch
    lateinit var rGroup1: RadioGroup
    lateinit var rdoOreO : RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQ : RadioButton
    lateinit var btnExit : Button
    lateinit var btnHome : Button
    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "안드로이드 사진 보기"

        text1 = findViewById<TextView>(R.id.Text1)
        chkAgree = findViewById<Switch>(R.id.ChkAgree)

        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        rdoOreO = findViewById<RadioButton>(R.id.RdoDog)
        rdoQ = findViewById<RadioButton>(R.id.Rdorabbit)
        rdoPie= findViewById<RadioButton>(R.id.Rdocat)

        btnExit = findViewById<Button>(R.id.exit)
        btnHome = findViewById<Button>(R.id.home)
        imgPet = findViewById<ImageView>(R.id.ImgPet)

        chkAgree.setOnCheckedChangeListener { compoundButton, b ->
            if(chkAgree.isChecked == true) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnExit.visibility = android.view.View.VISIBLE
                btnHome.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
                imgPet.layoutParams.height = 600;
                imgPet.requestLayout()
            } else {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnExit.visibility = android.view.View.INVISIBLE
                btnHome.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }

        rGroup1.setOnCheckedChangeListener { radioGroup: RadioGroup, i: Int ->
            when (rGroup1.checkedRadioButtonId) {
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.Rdorabbit -> imgPet.setImageResource(R.drawable.rabbit)
                R.id.Rdocat -> imgPet.setImageResource(R.drawable.cat)
                else -> imgPet.setImageResource(0)
            }
//            imgPet.visibility = View.VISIBLE
        }

        btnExit.setOnClickListener {
            finish()
        }

        btnHome.setOnClickListener {
            rdoOreO.isChecked = false
            rdoPie.isChecked = false
            rdoQ.isChecked = false
            chkAgree.isChecked = false
            imgPet.setImageResource(0)
            imgPet.visibility = View.INVISIBLE
            imgPet.requestLayout()
        }
    }
}