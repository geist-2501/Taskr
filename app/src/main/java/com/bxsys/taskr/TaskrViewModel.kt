package com.bxsys.taskr

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

// Tends to only have the log service.
open class TaskrViewModel: ViewModel() {
    open val showErrorExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    open val logErrorExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        TODO("Implement logger")
    }

    open fun onError(error: Throwable) {
        Log.e("e", error.message, error)
    }
}