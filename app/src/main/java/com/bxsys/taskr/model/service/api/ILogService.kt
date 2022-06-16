package com.bxsys.taskr.model.service.api

interface ILogService {
    fun logNonFatalCrash(throwable: Throwable)
}