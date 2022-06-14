package com.bxsys.taskr.model.service.api

interface IUserService {
    fun hasUser(): Boolean
    fun signIn(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun signUp(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun signOut()
}