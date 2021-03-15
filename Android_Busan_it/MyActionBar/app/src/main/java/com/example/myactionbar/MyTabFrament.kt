package com.example.myactionbar

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class
MyTabFrament : androidx.fragment.app.Fragment() {
    var tabName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data = arguments
        tabName = data!!.getString("tabName")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)

        var baseLayout = LinearLayout(super.getActivity())
        baseLayout.orientation = LinearLayout.VERTICAL
        baseLayout.layoutParams = params

        if(tabName === "음악별") baseLayout.setBackgroundColor(Color.RED)
        if(tabName === "가수별") baseLayout.setBackgroundColor(Color.GREEN)
        if(tabName === "앨범별") baseLayout.setBackgroundColor(Color.BLACK)

        return baseLayout
    }
}