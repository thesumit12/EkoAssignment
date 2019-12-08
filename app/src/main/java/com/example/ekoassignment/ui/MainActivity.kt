package com.example.ekoassignment.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ekoassignment.BR
import com.example.ekoassignment.R
import com.example.ekoassignment.components.BaseActivity
import com.example.ekoassignment.databinding.ActivityMainBinding
import com.example.ekoassignment.model.TodoItem
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    val mainViewModel: MainViewModel by viewModel()

    private lateinit var adapter: TodoListAdapter

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBar()
        adapter = TodoListAdapter(this)
        setupRecyclerView()
        subscribeObservers()
    }

    private fun setActionBar() {
        supportActionBar?.title = "Todo List"
    }

    private fun setupRecyclerView() {
        rv_todo.layoutManager = LinearLayoutManager(this)
        rv_todo.adapter = adapter
        rv_todo.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun subscribeObservers() {
        mainViewModel.todoList.observe(this, Observer {todoList ->
            renderList(todoList)
        })

        mainViewModel.loadingMsg.observe(this, Observer {msg->
            if (msg != null) {
                showWaitingDialog(msg)
            }else{
                hideWaitingDialog()
            }
        })
    }

    private fun renderList(pagedTodoList: PagedList<TodoItem>) {
        adapter.submitList(pagedTodoList)
        if (pagedTodoList.isEmpty()) {
            mainViewModel.noData.set(true)
            mainViewModel.getTodoListFromServer()
        }
        else {
            mainViewModel.noData.set(false)
            mainViewModel.loadingMsg.value = null
        }

    }
}
