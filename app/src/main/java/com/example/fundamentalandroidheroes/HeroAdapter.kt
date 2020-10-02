package com.example.fundamentalandroidheroes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.fundamentalandroidheroes.model.Hero

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    var heroes = arrayListOf<Hero>()

    override fun getCount(): Int = heroes.size

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.hero_item, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Hero

        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder(view: View) {
        private val name: TextView = view.findViewById(R.id.name)
        private val detail: TextView = view.findViewById(R.id.detail)
        private val image: ImageView = view.findViewById(R.id.image)

        fun bind(hero: Hero) {
            name.text = hero.name
            detail.text = hero.detail
            image.setImageResource(hero.image)
        }
    }
}