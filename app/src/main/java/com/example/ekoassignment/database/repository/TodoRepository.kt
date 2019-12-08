package com.example.ekoassignment.database.repository

import androidx.paging.DataSource
import com.example.ekoassignment.apiManager.ApiManager
import com.example.ekoassignment.database.dao.TodoDao
import com.example.ekoassignment.database.helper.toDbEntity
import com.example.ekoassignment.database.helper.toModel
import com.example.ekoassignment.model.TodoItem
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Repository class to To_do Entity.
 * @author Sumit Lakra
 * @date 12/07/19
 */
class TodoRepository(private val todoDao: TodoDao, private val apiManager: ApiManager) {

    /**
     * Method to get all todos.
     * @return [DataSource.Factory]
     * @author Sumit Lakra
     * @date 12/07/19
     */
    fun getTodoList(): DataSource.Factory<Int, TodoItem> =
        todoDao.getAllTodos().map { it.toModel() }

    @ExperimentalCoroutinesApi
    suspend fun getTodoListFromServer() {
        val list = apiManager.getTodoList()
        if (list.isNotEmpty()) {
            todoDao.insertAll(list.map { it.toDbEntity() })
        }
    }
}