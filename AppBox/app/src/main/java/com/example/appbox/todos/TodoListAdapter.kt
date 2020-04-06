package com.example.appbox.todos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.R

class TodoListAdapter(private val todos: ArrayList<String>) :
    RecyclerView.Adapter<TodoListAdapter.TodoItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TodoItemHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {
        val todoItem: String = todos[position]
        holder.bind(todoItem)
    }

    override fun getItemCount() = todos.size

    class TodoItemHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.todo_item_view, parent, false)) {
        private var mTodo: TextView? = null
        private var mDeleteBtn: ImageButton? = null

        init {
            mTodo = itemView.findViewById(R.id.todoItem)
            mDeleteBtn = itemView.findViewById(R.id.deleteBtn)
        }

        fun bind(todoItem: String) {
            mTodo?.text = todoItem
        }


    }
}