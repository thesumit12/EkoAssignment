package com.example.ekoassignment.network

import com.example.ekoassignment.model.TodoItem
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * Interface for api endpoints.
 * @author Sumit Lakra
 * @date 12/07/19
 */
interface IApiService {

    @GET("todos")
    fun getTodoList(): Deferred<List<TodoItem>>
}