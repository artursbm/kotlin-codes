package com.example.appbox

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var itemList = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, itemList)

        addNote.setOnClickListener { view ->
            itemList.add(todoItem.text.toString())
            todoList.adapter = adapter
            adapter.notifyDataSetChanged()
            todoItem.text = null
            Snackbar.make(view, R.string.added_idea, Snackbar.LENGTH_SHORT).show()

        }
    }

}
