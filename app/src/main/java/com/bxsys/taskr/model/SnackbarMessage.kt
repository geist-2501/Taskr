package com.bxsys.taskr.model

class SnackbarMessage(
    val message: String
) {
    companion object {
        fun Throwable.toSnackbarMessage(): SnackbarMessage {
            val message = this.message.orEmpty()
            return if (message.isNotBlank()) SnackbarMessage(message)
            else SnackbarMessage("An unspecified failure has occurred")
        }
    }
}