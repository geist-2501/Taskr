package com.bxsys.taskr

import androidx.compose.material.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bxsys.taskr.model.service.api.ISnackbarService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskrViewModel @Inject constructor(
    private val snackbarService: ISnackbarService
): ViewModel() {

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