package com.example.ekoassignment.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class for to_do items.
 * @author Sumit Lakra
 * @date 12/07/19
 */
@Entity(tableName = "todo_table")
class ToDoEntity {

    @PrimaryKey
    var id:Int = 0

    @ColumnInfo(name = "user_id")
    var userId: Int = 0

    var title: String = ""

    var status: Boolean = false
}