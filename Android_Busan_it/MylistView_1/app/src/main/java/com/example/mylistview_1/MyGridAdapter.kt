package com.example.mylistview_1

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.annotation.MainThread

class MyGridAdapter(var context: Context) : BaseAdapter() {


    var posterID = arrayOf(R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
        R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
        R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
        R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
        R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
        R.drawable.mov17, R.drawable.mov18, R.drawable.mov19,
        R.drawable.mov20, R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
        R.drawable.mov24, R.drawable.mov25, R.drawable.mov26,
        R.drawable.mov27, R.drawable.mov28, R.drawable.mov29,
        R.drawable.mov30, R.drawable.mov31, R.drawable.mov32, R.drawable.mov33,
        R.drawable.mov34, R.drawable.mov35, R.drawable.mov36,
        R.drawable.mov37, R.drawable.mov38, R.drawable.mov39,
        R.drawable.mov40)

    var posterTitle = arrayOf("제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7", "제목8", "제목9", "제목10",
        "제목11", "제목12", "제목13", "제목14", "제목15", "제목16", "제목17", "제목18", "제목19", "제목20",
        "제목21", "제목22", "제목23", "제목24", "제목25", "제목26", "제목27", "제목28", "제목29", "제목30",
        "제목31", "제목32", "제목33", "제목34", "제목35", "제목36", "제목37", "제목38", "제목39", "제목40")


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imageView = ImageView(context)

        imageView.layoutParams = ViewGroup.LayoutParams(200, 300)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        imageView.setPadding(5,5,5,5)

        imageView.setImageResource(posterID[position])


        imageView.setOnClickListener {
            var dialogView = View.inflate(context, R.layout.dialog, null)
            var dlg = AlertDialog.Builder(context)
            var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
            ivPoster.setImageResource(posterID[position])
            dlg.setTitle(posterTitle[position])
            dlg.setIcon(R.drawable.ic_launcher)
            dlg.setView(dialogView)
            dlg.setNegativeButton("닫기", null)
            dlg.show()
        }

        return imageView
    }

    override fun getItem(position: Int): Any {
        return 0;
    }

    override fun getItemId(position: Int): Long {
        return 0;
    }

    override fun getCount(): Int {
        return posterID.size
    }
}