package com.mk.template.di

object InjectorProvider {

    fun modulesList() = listOf(
        dataSourceModule, localModule, networkModule,
        repositoryModule, useCaseModule, viewModelModule
    )


}
