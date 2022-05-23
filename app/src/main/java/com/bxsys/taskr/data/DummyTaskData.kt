package com.bxsys.taskr.data

import com.bxsys.taskr.model.Task

fun getDummyTaskData(): List<Task> {
    return List(15) { i -> Task(i, "Task #$i") }
}