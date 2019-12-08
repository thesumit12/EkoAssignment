package com.example.ekoassignment.apiManager

import android.util.Log
import com.example.ekoassignment.model.TodoItem
import com.example.ekoassignment.network.IApiService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@ExperimentalCoroutinesApi
@RunWith(PowerMockRunner::class)
@PrepareForTest(Log::class)
class ApiManagerTest {

    @Before
    fun setUp() {
        PowerMockito.mockStatic(Log::class.java)
        Mockito.`when`(Log.e(any(), any())).then {
            println(it.arguments[1] as String)
        }
    }

    @Test
    fun getTodoListTest() = runBlocking {
        val apiService: IApiService = mock()
        val apiManager = ApiManager(apiService)

        var ans = 0
        val result: Deferred<List<TodoItem>> = mock()
        whenever(apiService.getTodoList()).thenReturn(result)
        whenever(result.join()).then {
            ans = 2
            ans
        }

        val todoList = ArrayList<TodoItem>()
        todoList.add(TodoItem())
        whenever(result.getCompleted()).thenReturn(todoList)

        val ret = apiManager.getTodoList()
        Assert.assertEquals(1, ret.size)
        Assert.assertEquals(2, ans)
    }

    @Test
    fun getTodoListEmptyTest() = runBlocking {
        val apiService: IApiService = mock()
        val apiManager = ApiManager(apiService)

        var ans = 0
        val result: Deferred<List<TodoItem>> = mock()
        whenever(apiService.getTodoList()).thenReturn(result)
        whenever(result.join()).then {
            ans = 2
            ans
        }

        whenever(result.getCompleted()).thenReturn(null)

        val ret = apiManager.getTodoList()
        Assert.assertTrue(ret.isEmpty())
    }
}