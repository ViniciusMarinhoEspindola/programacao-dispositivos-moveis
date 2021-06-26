package com.vinicius.app8_pets_com_foto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvPets)

        val listaPets = mutableListOf<Pet>(
            Pet(nome="Scooby Doo", idade="3 Anos", tipo=Tipo.CACHORRO, raca="Dogue Alemão", img=resources.getDrawable(R.drawable.scooby_doo)),
            Pet(nome="Garfield", idade="8 Anos", tipo=Tipo.GATO, raca="Gato Persa", img=resources.getDrawable(R.drawable.garflield)),
            Pet(nome="Snoopy", idade="5 Anos", tipo=Tipo.CACHORRO, raca="Beagle"),
        )

        rv.adapter = PetAdapter(listaPets)

        rv.layoutManager = LinearLayoutManager(this)
    }
}