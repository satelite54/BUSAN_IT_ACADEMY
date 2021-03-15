package com.example.myactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentTransaction

@Suppress("deprecation")
class MainActivity : AppCompatActivity(), ActionBar.TabListener {

    lateinit var tabSong : ActionBar.Tab
    lateinit var tabArtist : ActionBar.Tab
    lateinit var tabAlbum : ActionBar.Tab

    var myFrags = arrayOfNulls<MyTabFrament>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bar = this.supportActionBar
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        tabSong = bar.newTab()
        tabSong.text = "음악별"
        tabSong.setTabListener(this)
        bar.addTab(tabSong)

        tabArtist = bar.newTab()
        tabArtist.text = "가수별"
        tabArtist.setTabListener(this)
        bar.addTab(tabArtist)

        tabAlbum = bar.newTab()
        tabAlbum.text = "앨범별"
        tabAlbum.setTabListener(this)
        bar.addTab(tabAlbum)
    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        TODO()
    }
    override fun onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        var myTabFrag : MyTabFrament? = null

        if(myFrags[tab.position] == null) {
            myTabFrag = MyTabFrament()
            val data = Bundle()
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            myFrags[tab.position] = myTabFrag
        } else {
            myTabFrag = myFrags[tab.position]
        }
        ft.replace(android.R.id.content, myTabFrag!!)
    }
    override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {

    }
}