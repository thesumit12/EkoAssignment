package com.example.ekoassignment.di

import com.example.ekoassignment.database.repository.TodoRepository
import org.koin.dsl.module.module

/**
 * Module will initialize all repositories.
 * @author Sumit Lakra
 * @date 12/07/19
 */
internal val repositoryModule = module {

    single { TodoRepository(todoDao = get(), apiManager = get()) }
}