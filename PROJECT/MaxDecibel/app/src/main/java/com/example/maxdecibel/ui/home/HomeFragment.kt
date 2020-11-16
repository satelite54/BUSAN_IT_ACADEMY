package com.example.maxdecibel.ui.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import com.example.maxdecibel.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var runCount = 0
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        root.MeasurementDB_btn.setOnClickListener() {
            var Thread = ThreadClass()
            Thread.run()
        }
        return root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        MeasurementDB_btn
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        fcontext = context
    }
    inner class ThreadClass:Thread(){
        override fun run(){ // UI 스레드 생성 Glide 사용 시 메인 스레드에서만 UI 변경해야해서
                activity!!.runOnUiThread {
                    val rabbit = view?.findViewById(R.id.imageView2) as ImageView
                    val gifImage = GlideDrawableImageViewTarget(rabbit)
                    Glide.with(activity!!.applicationContext).load(R.drawable.openning).into(gifImage)
                }
            }
        }
    }