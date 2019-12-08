package com.example.ekoassignment.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.ekoassignment.components.BaseViewModel
import com.example.ekoassignment.database.repository.TodoRepository
import com.example.ekoassignment.model.TodoItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

/**
 * ViewModel for MainActivity.
 * @author Sumit Lakra
 * @date 12/07/19
 */

private const val PAGE_SIZE = 10
private const val INITIAL_LOAD_SIZE_HINT = 20

class MainViewModel(private val todoRepository: TodoRepository): BaseViewModel() {

    val noData = ObservableBoolean(true)
    val loadingMsg = MutableLiveData<String>("")

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPageSize(PAGE_SIZE)
        .build()

    val todoList = LivePagedListBuilder<Int, TodoItem>(
        todoRepository.getTodoList(), pagedListConfig).build()

    @ExperimentalCoroutinesApi
    fun getTodoListFromServer() {
        loadingMsg.value = "Fetching List.."
        CoroutineScope(Dispatchers.IO).launch {
            todoRepository.getTodoListFromServer()
        }
    }
}