package com.bxsys.taskr.model.service.module

import com.bxsys.taskr.model.service.*
import com.bxsys.taskr.model.service.api.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun provideTaskService(impl: FirebaseTaskService): ITaskService

    @Binds
    abstract fun provideUserService(impl: FirebaseUserService): IUserService

    @Singleton
    @Binds
    abstract fun provideSnackbarService(impl: SnackbarService): ISnackbarService

    @Binds
    abstract fun provideLogService(impl: FirebaseLogService): ILogService

    @Binds
    abstract fun provideErrorHandlerService(impl: CrashlyticsErrorHandlerService): IErrorHandlerService
}