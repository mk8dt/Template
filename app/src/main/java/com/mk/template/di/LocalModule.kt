package com.mk.template.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.mk.data.database.TemplateDatabase
import com.mk.data.database.dao.UserDao
import com.mk.template.data.TemplateSharedPreferences
import com.mk.template.data.UserSettings
import com.mk.template.data.UserSettingsImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {

    single<SharedPreferences> {
        androidContext().getSharedPreferences("Template", Context.MODE_PRIVATE)
    }

    single { TemplateSharedPreferences(get()) }
    single<UserSettings> { UserSettingsImpl(get()) }

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = TemplateDatabase::class.java,
            name = "template_database"
        ).build()
    }

    single<UserDao> { get<TemplateDatabase>().userDao() }
}