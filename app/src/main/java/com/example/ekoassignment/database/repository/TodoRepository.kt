package com.example.ekoassignment.database.repository

import com.example.ekoassignment.apiManager.ApiManager
import com.example.ekoassignment.database.dao.TodoDao

/**
 * Repository class to To_do Entity.
 * @author Sumit Lakra
 * @date 12/07/19
 */
class TodoRepository(val todoDao: TodoDao, val apiManager: ApiManager) {
}