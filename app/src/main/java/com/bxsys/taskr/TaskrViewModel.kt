package com.bxsys.taskr

import android.util.Log
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bxsys.taskr.model.SnackbarMessage
import com.bxsys.taskr.model.SnackbarMessage.Companion.toSnackbarMessage
import com.bxsys.taskr.model.service.SnackbarService
import com.bxsys.taskr.model.service.api.ILogService
import com.bxsys.taskr.model.service.api.ISnackbarService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

// Tends to only have the log service.
open class TaskrViewModel(
    protected val logService: ILogService,
    protected val snackbarService: ISnackbarService
): ViewModel() {

    open val showErrorExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    open val logErrorExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        logService.logNonFatalCrash(throwable)
    }

    open fun onError(error: Throwable) {
        logService.logNonFatalCrash(error)
        snackbarService.showMessage(error.toSnackbarMessage())
    }
}

@HiltViewModel
class TaskrRootViewModel @Inject constructor(
    snackbarService: ISnackbarService,
    logService: ILogService
): TaskrViewModel(logService, snackbarService) {

    val snackbarHostState: SnackbarHostState
        get() = snackbarService.snackbarHostState

    init {
        viewModelScope.launch {
            snackbarService.snackbarMessages.filterNotNull().collect { snackbarMessage ->
                snackbarHostState.showSnackbar(snackbarMessage.message)
            }
        }
    }
}