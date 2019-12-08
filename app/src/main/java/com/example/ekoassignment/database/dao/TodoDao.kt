package com.example.ekoassignment.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.example.ekoassignment.database.entity.ToDoEntity

/**
 * Dao class for todo_table.
 * @author Sumit Lakra
 * @date 12/07/19
 */
@Dao
abstract class TodoDao: RoomBaseDao<ToDoEntity>() {

    @Query("SELECT * FROM todo_table ORDER BY user_id ASC")
    abstract fun getAllTodos(): DataSource.Factory<Int, ToDoEntity>
}