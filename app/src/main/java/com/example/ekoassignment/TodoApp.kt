package com.example.ekoassignment

import android.app.Application
import com.example.ekoassignment.di.appModule
import org.koin.android.ext.android.startKoin

/**
 * Class that extends Application class. It contains all the application level initializations.
 * @author Sumit Lakra
 * @date 12/07/19
 */
class TodoApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }

    private fun initKoin() {
        startKoin(this, appModule)
    }
}