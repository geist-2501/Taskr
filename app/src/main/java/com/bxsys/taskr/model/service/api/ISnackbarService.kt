package com.bxsys.taskr.model.service.api

import androidx.compose.material.SnackbarHostState
import com.bxsys.taskr.model.SnackbarMessage
import kotlinx.coroutines.flow.StateFlow

interface ISnackbarService {
    val snackbarMessages: StateFlow<SnackbarMessage?>
    val snackbarHostState: SnackbarHostState

    fun showMessage(message: String)
    fun showMessage(message: SnackbarMessage)
}