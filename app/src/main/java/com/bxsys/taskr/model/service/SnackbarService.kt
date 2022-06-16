package com.bxsys.taskr.model.service

import android.util.Log
import androidx.compose.material.SnackbarHostState
import com.bxsys.taskr.model.SnackbarMessage
import com.bxsys.taskr.model.service.api.ISnackbarService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SnackbarService @Inject constructor(): ISnackbarService {

    private val messages: MutableStateFlow<SnackbarMessage?> = MutableStateFlow(null)
    override val snackbarMessages: StateFlow<SnackbarMessage?>
        get() = messages.asStateFlow()

    override val snackbarHostState = SnackbarHostState()

    override fun showMessage(message: String) {
        messages.value = SnackbarMessage(message)
    }

    override fun showMessage(message: SnackbarMessage) {
        messages.value = message
    }
}