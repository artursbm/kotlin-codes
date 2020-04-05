package com.example.appbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        // this will add the layout manager that makes recycler view works,
        // and will set the todoList to be managed by the layout manager
        linearLayoutManager = LinearLayoutManager(this)
        todoList.layoutManager = linearLayoutManager

        var itemList = arrayListOf<String>()
//        var adapter = ListAdapter<String>(this, android.R.layout.simple_selectable_list_item, itemList)

        addNote.setOnClickListener { view ->
            itemList.add(newTodoItem.text.toString())
//            todoList.adapter = adapter
//            adapter.notifyDataSetChanged()
            newTodoItem.text = null
            Snackbar.make(view, R.string.added_idea, Snackbar.LENGTH_SHORT).show()

        }
    }

}
