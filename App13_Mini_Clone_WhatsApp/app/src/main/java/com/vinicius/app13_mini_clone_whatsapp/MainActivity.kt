package com.vinicius.app13_mini_clone_whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var menu: TabLayout
    lateinit var visualizador: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.tblMenu)
        visualizador = findViewById(R.id.vpgVisualizador)

        visualizador.adapter = PagerAdapter(supportFragmentManager)
        menu.setupWithViewPager(visualizador)

    }
}