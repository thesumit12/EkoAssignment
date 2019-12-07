package com.example.ekoassignment.di

import com.example.ekoassignment.apiManager.ApiManager
import org.koin.dsl.module.module

/**
 * Module to initialize ApiManager.
 * @author Sumit Lakra
 * @date 12/07/19
 */
internal val managerModule = module {

    single { ApiManager(apiService = get()) }
}