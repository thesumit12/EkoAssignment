package com.example.ekoassignment.model

/**
 * Model class for to_do item.
 * @author Sumit Lakra
 * @date 12/07/19
 */
data class TodoItem(
    var userId: Int = -1,
    var id: Int = -1,
    var title: String = "",
    var completed: Boolean = false
)