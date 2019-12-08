package com.example.ekoassignment.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.example.ekoassignment.database.repository.TodoRepository
import com.example.ekoassignment.model.TodoItem
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private fun sleep() {
        Thread.sleep(500)
    }

    @Test
    fun initTest() {
        val repository: TodoRepository = mock()
        val factory: DataSource.Factory<Int, TodoItem> = mock()
        whenever(repository.getTodoList()).thenReturn(factory)

        val viewModel = MainViewModel(repository)

        assertTrue(viewModel.noData.get())
        assertEquals("", viewModel.loadingMsg.value)
        assertTrue(viewModel.todoList.value == null)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTodoListFromServerTest() {
        val repository: TodoRepository = mock()
        val factory: DataSource.Factory<Int, TodoItem> = mock()
        whenever(repository.getTodoList()).thenReturn(factory)

        val viewModel = MainViewModel(repository)
        runBlocking {
            viewModel.getTodoListFromServer()
            sleep()
            verify(repository, times(1)).getTodoListFromServer()
        }
    }
}