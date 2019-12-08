package com.example.ekoassignment.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.ekoassignment.R
import com.example.ekoassignment.databinding.TodoItemBinding
import com.example.ekoassignment.model.TodoItem

class TodoListAdapter(private val context: Context): PagedListAdapter<TodoItem, TodoViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding: TodoItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.todo_item, parent, false
        )

        return TodoViewHolder(binding)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<TodoItem>() {

            override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean =
                oldItem == newItem
        }
    }
}