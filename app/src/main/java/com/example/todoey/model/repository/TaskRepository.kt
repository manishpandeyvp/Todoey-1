package com.example.todoey.model.repository

import com.example.todoey.MyApplication
import com.example.todoey.model.data.task.Task
import com.example.todoey.model.data.task.TaskDB
import com.example.todoey.model.data.task.TaskDao
import com.example.todoey.ui.authenticate.login.sharedPreference
import com.example.todoey.utils.Constants
import com.example.todoey.utils.Internet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TaskRepository {

    private val fireStore = Firebase.firestore
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val taskDao: TaskDao = TaskDB.getDatabase(MyApplication.getContext()).taskDao()


    suspend fun addTask(task: Task) {
        taskDao.addTask(task)
        if (sharedPreference.getBoolean(
                Constants.IS_CONNECTED_TO_INTERNET,
                Internet.hasInternetConnectivity(MyApplication.getContext())
            )
        ) {
            firebaseAuth.currentUser?.let {
                fireStore.collection(Constants.TASKS).document(it.uid).collection(Constants.TASKS)
                    .add(task)
            }
        }
    }

    fun getAllTasks(): ArrayList<Task> {
        var tasks: ArrayList<Task> = ArrayList()

        if (sharedPreference.getBoolean(
                Constants.IS_CONNECTED_TO_INTERNET,
                Internet.hasInternetConnectivity(MyApplication.getContext())
            )
        ) {
            firebaseAuth.currentUser?.let {
                fireStore.collection(Constants.TASKS).document(it.uid).collection(Constants.TASKS)
                    .get().addOnSuccessListener { document ->
                        for(i in document.documents){
                            val task = i.toObject(Task::class.java)!!
                            tasks.add(task)
                        }
                    }
            }
        }

        return tasks
    }
}