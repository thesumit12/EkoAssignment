package com.example.ekoassignment.database.helper

import com.example.ekoassignment.database.entity.ToDoEntity
import com.example.ekoassignment.model.TodoItem

/**
 * Extension function to convert [ToDoEntity] into [TodoItem].
 * @return [TodoItem]
 * @author Sumit Lakra
 * @date 12/07/19
 */
fun ToDoEntity.toModel(): TodoItem = TodoItem(
    userId = userId, id = id, title = title, completed = status
)

/**
 * Extension function to convert [TodoItem] into [ToDoEntity].
 * @return [ToDoEntity]
 * @author Sumit Lakra
 * @date 12/07/19
 */
fun TodoItem.toDbEntity(): ToDoEntity {
    val en = ToDoEntity()
    en.id = this.id
    en.userId = this.userId
    en.title = this.title
    en.status = this.completed

    return en
}