package com.example.androidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Subjects>
    lateinit var textId : Array<String>
    lateinit var imageId : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        imageId = arrayOf(
            R.drawable.andro,
            R.drawable.angular,
            R.drawable.calculator,
            R.drawable.epsilon,
            R.drawable.javai,
            R.drawable.pi,
            R.drawable.python,
            R.drawable.springb

        )

        textId = arrayOf(
            "Android Materials",
            "Angular framework Materials",
            "Algebra Materials",
            "Analysis Materials",
            "Java Materials",
            "Geometry Materials",
            "Python Materials",
            "Spring Boot framework Materials"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Subjects>()
        getData()

    }
    private fun getData(){

        for(i in imageId.indices){
            val subjects = Subjects(imageId[i],textId[i])
            newArrayList.add(subjects)
        }
        newRecyclerView.adapter = NewAdapter(newArrayList)
    }
}