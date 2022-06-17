package com.bxsys.taskr.ui.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bxsys.taskr.model.Task
import com.bxsys.taskr.model.service.api.IErrorHandlerService
import com.bxsys.taskr.model.service.api.ITaskService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val taskService: ITaskService,
    private val errorHandler: IErrorHandlerService
): ViewModel() {

    var tasks = mutableStateListOf<Task>()
        private set

    fun addListener() {
        viewModelScope.launch(errorHandler.showErrorExceptionHandler) {
            taskService.addListener(::handleTasksChanged, errorHandler::onError)
        }
    }

    fun removeListener() {
        viewModelScope.launch(errorHandler.showErrorExceptionHandler) { taskService.removeListener() }
    }

    fun handleNewTaskClick(task: Task) {
        viewModelScope.launch(errorHandler.showErrorExceptionHandler) {
            taskService.saveTask(task) { error ->
                if (error != null) errorHandler.onError(error)
            }
        }
    }

    fun handleDeleteTaskClick(task: Task) {
        viewModelScope.launch(errorHandler.showErrorExceptionHandler) {
            taskService.deleteTask(task.id) { error ->
                if (error != null) errorHandler.onError(error)
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