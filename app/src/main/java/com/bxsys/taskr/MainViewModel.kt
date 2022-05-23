package com.bxsys.taskr

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.bxsys.taskr.data.getDummyTaskData
import com.bxsys.taskr.model.Task

class MainViewModel: ViewModel() {
    var tasks = getDummyTaskData().toMutableStateList()

    fun handleNewTask(task: Task) {
        tasks.add(task)
    }

    fun handleRemoveTask(task: Task) {
        tasks.remove(task)
    }
}