package com.vinicius.app14_conheca_me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        // TabLayout --> ViewPager --> Adapter
        visualizador.adapter = PagerAdapter(supportFragmentManager)
        menu.setupWithViewPager(visualizador)
    }
}