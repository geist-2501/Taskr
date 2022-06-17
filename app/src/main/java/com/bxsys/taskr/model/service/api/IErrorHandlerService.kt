package com.bxsys.taskr.model.service.api

import kotlinx.coroutines.CoroutineExceptionHandler

interface IErrorHandlerService {
    val showErrorExceptionHandler: CoroutineExceptionHandler
    val logErrorExceptionHandler: CoroutineExceptionHandler
    fun onError(error: Throwable)
}