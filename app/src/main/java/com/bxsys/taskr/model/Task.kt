package com.bxsys.taskr.model

import java.util.*

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val content: String = "",
    val userId: String = ""
)
