package com.example.appbox.todos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appbox.R
import com.example.appbox.todos.models.Todo
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.todo_item_view.view.*

class TodoListAdapter(private val todos: ArrayList<Todo>, private val context: Context) :
    RecyclerView.Adapter<TodoListAdapter.TodoItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item_view, parent, false)
        return TodoItemHolder(view)
    }

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {
        // only use the position argument when item is first instanced.
        // After that, if there is a change to the adapter (like removing an item from the list)
        // if the position of the item is needed, call adapterPosition from the holder, which is
        // automatically updated when there is a change in the RecyclerView
        val todo = todos[holder.adapterPosition]
        holder.bind(todo)
        holder.itemView.deleteBtn.setOnClickListener {
            Snackbar.make(it.rootView, R.string.deleteBtnTxt, Snackbar.LENGTH_SHORT).show()
            todos.remove(todo)
            notifyItemRemoved(holder.adapterPosition)
        }

    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class TodoItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var mTodo = v.todoItem
        private var mDeleteBtn = v.deleteBtn

        fun bind(todo: Todo) {
            mTodo.text = todo.todoText
        }
    }
}