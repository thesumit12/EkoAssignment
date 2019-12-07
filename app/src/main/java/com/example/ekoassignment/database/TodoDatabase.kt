package com.example.ekoassignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ekoassignment.database.dao.TodoDao
import com.example.ekoassignment.database.entity.ToDoEntity

/**
 * This class represents the RoomDatabase class from android. It contains abstract methods to
 * to get the Dao objects corresponding to each table . see DataBaseModule class for getting the instance
 * of this class.
 * @author Sumit Lakra
 * @date 12/07/19
 */
@Database(
    entities =[
    ToDoEntity::class
    ], version = 1, exportSchema = false
)
abstract class TodoDatabase: RoomDatabase() {

    /**
     * returns to_do dao instance.
     * @return [TodoDao]
     * @author Sumit Lakra
     * @date 12/07/19
     */
    abstract fun todoDao(): TodoDao
}