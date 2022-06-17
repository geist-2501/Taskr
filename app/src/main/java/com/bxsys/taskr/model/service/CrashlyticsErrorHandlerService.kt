package com.bxsys.taskr.model.service

import com.bxsys.taskr.model.SnackbarMessage.Companion.toSnackbarMessage
import com.bxsys.taskr.model.service.api.IErrorHandlerService
import com.bxsys.taskr.model.service.api.ILogService
import com.bxsys.taskr.model.service.api.ISnackbarService
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

class CrashlyticsErrorHandlerService @Inject constructor(
    private val snackbarService: ISnackbarService,
    private val logService: ILogService
): IErrorHandlerService {

    override val showErrorExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    override val logErrorExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        logService.logNonFatalCrash(throwable)
    }

    override fun onError(error: Throwable) {
        snackbarService.showMessage(error.toSnackbarMessage())
        logService.logNonFatalCrash(error)
    }
}