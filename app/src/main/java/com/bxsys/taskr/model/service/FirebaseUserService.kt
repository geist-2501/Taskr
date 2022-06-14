package com.bxsys.taskr.model.service

import com.bxsys.taskr.model.service.api.IUserService
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseUserService @Inject constructor(): IUserService {
    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override fun signIn(email: String, password: String, onResult: (Throwable?) -> Unit) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                onResult(it.exception)
        }
    }

    override fun signUp(email: String, password: String, onResult: (Throwable?) -> Unit) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                onResult(it.exception)
            }
    }

    override fun signOut() {
        Firebase.auth.signOut()
    }
}