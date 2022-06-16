package com.bxsys.taskr.ui.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.bxsys.taskr.TaskrViewModel
import com.bxsys.taskr.model.Task
import com.bxsys.taskr.model.service.api.ILogService
import com.bxsys.taskr.model.service.api.ISnackbarService
import com.bxsys.taskr.model.service.api.ITaskService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val taskService: ITaskService,
    logService: ILogService,
    snackbarService: ISnackbarService
): TaskrViewModel(logService, snackbarService) {

    var tasks = mutableStateListOf<Task>()
        private set

    fun addListener() {
        viewModelScope.launch(showErrorExceptionHandler) {
            taskService.addListener(::handleTasksChanged, ::onError)
        }
    }

    fun removeListener() {
        viewModelScope.launch(showErrorExceptionHandler) { taskService.removeListener() }
    }

    fun handleNewTaskClick(task: Task) {
        viewModelScope.launch(showErrorExceptionHandler) {
            taskService.saveTask(task) { error ->
                if (error != null) onError(error)
            }
        }
    }

    fun handleDeleteTaskClick(task: Task) {
        viewModelScope.launch(showErrorExceptionHandler) {
            taskService.deleteTask(task.id) { error ->
                if (error != null) onError(error)
            }
        }
    }

    private fun handleTasksChanged(wasDocDeleted: Boolean, task: Task) {
        if (wasDocDeleted) {
            tasks.remove(task)
        } else {
            val taskIdx = tasks.indexOfFirst { it.id == task.id }
            if (taskIdx < 0) tasks.add(task) else tasks[taskIdx] = task
        }
    }
}