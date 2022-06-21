package com.cranked.genericadapter

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.cranked.generictest.adapter.insertInto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val quakes = mutableListOf<Quake>()
        repeat(80) {
            quakes += Quake("Name is $it", "Surname is $it")
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recylerView)
        recyclerView.insertInto(quakes, R.layout.row_item, {
            findViewById<TextView>(R.id.nameTextView).text = it.name
            findViewById<TextView>(R.id.surnameTextView).text = it.surname
        }, {
            Log.i("Item ", "Clicked to $name")
        })
    }

}

class Quake( val name: String, val surname: String)