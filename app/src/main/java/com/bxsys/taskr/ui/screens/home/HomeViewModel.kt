package com.bxsys.taskr.ui.screens.home

import androidx.compose.runtime.toMutableStateList
import com.bxsys.taskr.TaskrViewModel
import com.bxsys.taskr.data.getDummyTaskData
import com.bxsys.taskr.model.Task

class HomeViewModel : TaskrViewModel() {
    var tasks = getDummyTaskData().toMutableStateList()

    fun handleNewTask(task: Task) {
        tasks.add(task)
    }

    fun handleRemoveTask(task: Task) {
        tasks.remove(task)
    }
}