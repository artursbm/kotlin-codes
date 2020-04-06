package com.example.appbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.todos.TodoListAdapter
import com.example.appbox.todos.models.Todo
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var todoViewAdapter: RecyclerView.Adapter<*>
    private val itemList = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        linearLayoutManager = LinearLayoutManager(this)
        todoViewAdapter = TodoListAdapter(itemList, this)
        todoList.layoutManager = linearLayoutManager
        todoList.adapter = todoViewAdapter

        addNote.setOnClickListener { view ->
            if (newTodoItem.text.isNotBlank() || newTodoItem.text.isNotEmpty()) {
                val todo = Todo(newTodoItem.text.toString())
                itemList.add(todo)
                todoViewAdapter.notifyDataSetChanged()
                newTodoItem.text = null
                Snackbar.make(view, R.string.added_idea, Snackbar.LENGTH_SHORT).show()
            }
            Snackbar.make(view, R.string.please_insert_note, Snackbar.LENGTH_SHORT).show()

        }
    }

}
