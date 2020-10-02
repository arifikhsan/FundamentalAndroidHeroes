package com.example.fundamentalandroidheroes

import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentalandroidheroes.model.Hero
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: HeroAdapter
    private lateinit var name: Array<String>
    private lateinit var detail: Array<String>
    private lateinit var image: TypedArray
    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HeroAdapter(this)
        listViewHeroes.adapter = adapter

        prepare()
        addItem()

        listViewHeroes.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, heroes[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        name = resources.getStringArray(R.array.hero_names)
        detail = resources.getStringArray(R.array.hero_details)
        image = resources.obtainTypedArray(R.array.hero_images)
    }

    private fun addItem() {
        for (position in name.indices) {
            val hero = Hero(name[position], detail[position], image.getResourceId(position, -1))
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }
}