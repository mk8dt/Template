package com.mk.template

import android.app.Application
import com.mk.template.di.InjectorProvider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TemplateApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TemplateApp)
            modules(InjectorProvider.modulesList())
        }
    }

}