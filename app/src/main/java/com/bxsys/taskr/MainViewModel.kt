package com.bxsys.taskr

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.bxsys.taskr.data.getDummyTaskData

class MainViewModel: ViewModel() {
    var tasks = getDummyTaskData().toMutableStateList()
}