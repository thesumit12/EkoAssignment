package com.example.ekoassignment.database.repository

import com.example.ekoassignment.apiManager.ApiManager
import com.example.ekoassignment.database.dao.TodoDao
import com.example.ekoassignment.model.TodoItem
import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test


class TodoRepositoryTest {

    @ExperimentalCoroutinesApi
    @Test
    fun getTodoListFromServerTest() = runBlocking{
        val todoDao: TodoDao = mock()
        val apiManager: ApiManager = mock()

        val repository = TodoRepository(todoDao, apiManager)

        val list = ArrayList<TodoItem>()
        list.add(TodoItem(1,1,"test", true))
        whenever(apiManager.getTodoList()).thenReturn(list)

        repository.getTodoListFromServer()
        Assert.assertEquals(1, list.size)
    }

}