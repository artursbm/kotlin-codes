package com.example.appbox.todos

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.R

class TodoListAdapter(private val todos: ArrayList<String>) :
    RecyclerView.Adapter<TodoListAdapter.TodoItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {
        val todoView = LayoutInflater.from(parent.context).inflate(R.layout.todo_item_view, parent, false)
        return TodoItemHolder(todoView)
    }

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {

    }

    class TodoItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var todo: String? = null
        private var deleteBtn: ImageButton? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICKED")
        }

        companion object {
            private val TODO_KEY = "TODO"
        }
    }
}