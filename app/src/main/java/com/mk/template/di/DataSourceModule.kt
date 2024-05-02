package com.mk.template.di

import com.mk.data.datasource.CredentialsLocalDataSource
import com.mk.data.datasource.NotificationRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {

    single { CredentialsLocalDataSource(get()) }

    single { NotificationRemoteDataSource(get()) }

}
