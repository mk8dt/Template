package com.mk.template.di

import com.mk.domain.usecase.credentials.DeleteUserUseCase
import com.mk.domain.usecase.credentials.DeleteUserUseCaseImpl
import com.mk.domain.usecase.credentials.DoLoginUseCase
import com.mk.domain.usecase.credentials.DoLoginUseCaseImpl
import com.mk.domain.usecase.credentials.DoRegisterUseCase
import com.mk.domain.usecase.credentials.DoRegisterUseCaseImpl
import com.mk.domain.usecase.notification.GetAllNotificationUseCase
import com.mk.domain.usecase.notification.GetAllNotificationUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    factory<DoLoginUseCase> { DoLoginUseCaseImpl(get()) }
    factory<DoRegisterUseCase> { DoRegisterUseCaseImpl(get()) }
    factory<DeleteUserUseCase> { DeleteUserUseCaseImpl(get()) }

    factory<GetAllNotificationUseCase> { GetAllNotificationUseCaseImpl(get()) }
}
