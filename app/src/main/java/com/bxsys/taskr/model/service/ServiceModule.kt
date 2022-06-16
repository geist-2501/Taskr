package com.bxsys.taskr.model.service

import com.bxsys.taskr.model.service.api.ILogService
import com.bxsys.taskr.model.service.api.ISnackbarService
import com.bxsys.taskr.model.service.api.ITaskService
import com.bxsys.taskr.model.service.api.IUserService
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
}