package com.mk.template.di

import com.mk.data.repository.CredentialsRepositoryImpl
import com.mk.data.repository.NotificationRepositoryImpl
import com.mk.domain.repository.CredentialsRepository
import com.mk.domain.repository.NotificationRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<CredentialsRepository> { CredentialsRepositoryImpl(get()) }
    single<NotificationRepository> { NotificationRepositoryImpl(get()) }
}
