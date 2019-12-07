package com.example.ekoassignment.di

import com.example.ekoassignment.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Module will initialize all viewModels.
 * @author Sumit Lakra
 * @date 12/07/19
 */
internal val viewModelModule = module {

    viewModel { MainViewModel(todoRepository = get()) }
}