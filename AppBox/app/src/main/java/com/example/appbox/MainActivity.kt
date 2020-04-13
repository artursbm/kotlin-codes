package com.example.appbox

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.todos.TodoListAdapter
import com.example.appbox.todos.models.Todo
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var todoViewAdapter: RecyclerView.Adapter<*>
    private var itemList = arrayListOf<Todo>()

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
            } else {
                Snackbar.make(view, R.string.please_insert_note, Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val json: String? = sharedPreferences.getString(R.string.saved_list_key.toString(), null)
        val todosType = object : TypeToken<ArrayList<Todo>>() {}.type
        Gson().fromJson<ArrayList<Todo>>(json, todosType)?.let {
            itemList.addAll(Gson().fromJson<ArrayList<Todo>>(json, todosType))
            todoViewAdapter.notifyDataSetChanged()
        }
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val json: String = Gson().toJson(itemList)
        with(sharedPreferences.edit()) {
            putString(R.string.saved_list_key.toString(), json)
            apply()
        }

    }

}
