package com.example.ekoassignment.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.ekoassignment.BR
import com.example.ekoassignment.databinding.TodoItemBinding
import com.example.ekoassignment.model.TodoItem

class TodoViewHolder(private val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: TodoItem?) {
        binding.setVariable(BR.todoItem, data)
        binding.executePendingBindings()
    }
}