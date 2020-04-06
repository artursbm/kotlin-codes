package com.example.appbox.todos

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.R
import com.example.appbox.todos.models.Todo
import kotlinx.android.synthetic.main.todo_item_view.view.*

class TodoListAdapter(private val todos: List<Todo>, private val context: Context) :
    RecyclerView.Adapter<TodoListAdapter.TodoItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item_view, parent, false)
        return TodoItemHolder(view)
    }

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {
        val todo = todos[position]
        holder.itemView.todoItem.text = todo.todoText
        holder.itemView.deleteBtn.setOnClickListener(View.OnClickListener {
            Log.d("DELETE", "ITEM $position")
            notifyItemRemoved(position)
        })
    }

    override fun getItemCount() = todos.size

    class TodoItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var mTodo = v.todoItem
        private var mDeleteBtn = v.deleteBtn

    }
}