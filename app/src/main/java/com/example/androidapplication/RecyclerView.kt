package com.example.androidapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
//import android.widget.SearchView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class RecyclerView : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Subjects>
    lateinit var textId : Array<String>
    lateinit var imageId : Array<Int>
   // lateinit var subjects: Array<String>

    //for searchBar
    private lateinit var searchArrayList: ArrayList<Subjects>

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
        searchArrayList = arrayListOf<Subjects>()
        getData()

    }
    private fun getData(){

        for(i in imageId.indices){
            val subjects = Subjects(imageId[i],textId[i])
            newArrayList.add(subjects)
        }
        newRecyclerView.adapter = NewAdapter(newArrayList)
        searchArrayList.addAll(newArrayList)

        val adapter = NewAdapter(searchArrayList)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_bar,menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newSearchText: String?): Boolean {

                searchArrayList.clear()
                val searchText = newSearchText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){

                    newArrayList.forEach{
                        if (it.text_title.lowercase(Locale.getDefault()).contains(searchText)){

                            searchArrayList.add(it)

                        }
                    }

                    newRecyclerView.adapter!!.notifyDataSetChanged()

                }else{

                    searchArrayList.clear()
                    searchArrayList.addAll(newArrayList)
                    newRecyclerView.adapter!!.notifyDataSetChanged()

                }


                return false

            }


        })


        return super.onCreateOptionsMenu(menu)
    }


}