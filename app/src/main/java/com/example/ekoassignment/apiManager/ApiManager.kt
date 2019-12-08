package com.example.ekoassignment.apiManager

import android.util.Log
import com.example.ekoassignment.model.TodoItem
import com.example.ekoassignment.network.IApiService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.Exception

/**
 * Manager class to handle Api calls.
 * @author Sumit Lakra
 * @date 12/07/19
 */
open class ApiManager(val apiService: IApiService) {

    private val mTAG = ApiManager::class.java.simpleName

    @ExperimentalCoroutinesApi
    open suspend fun getTodoList(): List<TodoItem> {
        val request = apiService.getTodoList()
        val response = executeTodoCall(request)
        return if (response is List<*>) {
            response as List<TodoItem>
        } else
            arrayListOf()
    }

    @ExperimentalCoroutinesApi
    private suspend fun executeTodoCall(call: Deferred<List<TodoItem>>) = try {
        call.join()
        call.getCompleted()
    }catch (ex: Exception) {
        Log.e(mTAG,"Exception during network operation -> ${ex.printStackTrace()}")
    }
}