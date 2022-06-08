package com.bxsys.taskr.model.service

import com.bxsys.taskr.model.service.api.ITaskService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun provideTaskService(impl: FirebaseTaskService): ITaskService

}