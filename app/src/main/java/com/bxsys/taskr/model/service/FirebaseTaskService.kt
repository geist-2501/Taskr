package com.bxsys.taskr.model.service

import com.bxsys.taskr.model.Task
import com.bxsys.taskr.model.service.api.ITaskService
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseTaskService @Inject constructor(): ITaskService {

    private var listenerRegistration: ListenerRegistration? = null

    companion object {
        private const val TASK_COLLECTION = "Task"
    }

    override fun addListener(
        onDocumentEvent: (Boolean, Task) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val query = Firebase.firestore.collection(TASK_COLLECTION)

        listenerRegistration = query.addSnapshotListener { value, error ->
            if (error != null) {
                onError(error)
                return@addSnapshotListener
            }

            value?.documentChanges?.forEach {
                val wasDocDeleted = it.type == DocumentChange.Type.REMOVED
                onDocumentEvent(wasDocDeleted, it.document.toObject())
            }
        }
    }

    override fun removeListener() {
        listenerRegistration?.remove()
    }

    override fun getTask(taskId: String, onError: (Throwable) -> Unit, onSuccess: (Task) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun saveTask(task: Task, onResult: (Throwable?) -> Unit) {
        Firebase.firestore
            .collection(TASK_COLLECTION)
            .document(task.id)
            .set(task)
            .addOnCompleteListener { onResult(it.exception) }
    }

    override fun deleteTask(taskId: String, onResult: (Throwable?) -> Unit) {
        Firebase.firestore
            .collection(TASK_COLLECTION)
            .document(taskId)
            .delete()
            .addOnCompleteListener { onResult(it.exception) }
    }
}