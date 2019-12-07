package com.example.ekoassignment.database.dao

import androidx.room.Dao
import com.example.ekoassignment.database.entity.ToDoEntity

/**
 * Dao class for todo_table.
 * @author Sumit Lakra
 * @date 12/07/19
 */
@Dao
abstract class TodoDao: RoomBaseDao<ToDoEntity>() {


}