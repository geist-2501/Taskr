package com.bxsys.taskr.model.service

import com.bxsys.taskr.model.service.api.ILogService
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseLogService @Inject constructor(): ILogService {
    override fun logNonFatalCrash(throwable: Throwable) {
        Firebase.crashlytics.recordException(throwable)
    }
}