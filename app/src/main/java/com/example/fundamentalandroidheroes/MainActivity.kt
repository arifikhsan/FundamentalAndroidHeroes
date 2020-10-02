package com.example.fundamentalandroidheroes

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val heroes = arrayOf(
        "Cut Nyak Dien",
        "Ki Hajar Dewantara",
        "Moh Yamin",
        "Patimura",
        "R A Kartini",
        "Sukarno"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =
            ArrayAdapter(
                this,
                R.layout.list_item,
                R.id.textViewHeroName,
                heroes
            )

        listViewHeroes.adapter = adapter
    }
}