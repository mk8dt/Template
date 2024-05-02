package com.mk.template.di

import com.mk.data.api.MockApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {

    single { MockApi(androidContext()) }
}