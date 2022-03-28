package com.example.todoey.repository

import android.content.Context
import com.example.todoey.data.task.Task
import com.example.todoey.data.task.TaskDao
import com.example.todoey.ui.authenticate.login.sharedPreference
import com.example.todoey.utils.Constants
import com.example.todoey.utils.Internet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TaskRepository(
    private val taskDao: TaskDao,
    private val context: Context
) {

    private val fireStore = Firebase.firestore
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun addTask(task: Task) {
        taskDao.addTask(task)
        if (sharedPreference.getBoolean(
                Constants.IS_CONNECTED_TO_INTERNET,
                Internet.hasInternetConnectivity(context)
            )
        ) {
            firebaseAuth.currentUser?.let {
                fireStore.collection(Constants.TASKS).document(it.uid).collection(Constants.TASKS)
                    .add(task)
            }
        }
    }


}