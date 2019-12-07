package com.example.ekoassignment.di

import androidx.room.Room
import com.example.ekoassignment.database.TodoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * Module will initialize database and all dao objects.
 * @author Sumit Lakra
 * @date 12/07/19
 */
internal val databaseModule = module {

    // Room database
    single {
        Room.databaseBuilder(androidApplication(), TodoDatabase::class.java, "todo-db")
            .allowMainThreadQueries().build()
    }

    // Expose to_do dao
    single { get<TodoDatabase>().todoDao() }
}