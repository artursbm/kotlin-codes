package com.example.appbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.todos.TodoListAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var todoListRecyclerView: RecyclerView
    private lateinit var todoViewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        // this will add the layout manager that makes recycler view works,
        // and will set the todoList to be managed by the layout manager
        linearLayoutManager = LinearLayoutManager(this)
        todoViewAdapter = TodoListAdapter(arrayListOf())

        todoList.apply {
            layoutManager = linearLayoutManager
            adapter = todoViewAdapter
        }

        var itemList = arrayListOf<String>()

        addNote.setOnClickListener { view ->
            itemList.add(newTodoItem.text.toString())
            newTodoItem.text = null
            Snackbar.make(view, R.string.added_idea, Snackbar.LENGTH_SHORT).show()

        }
    }

}
