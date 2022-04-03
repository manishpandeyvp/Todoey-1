package com.example.todoey.model.repository

import androidx.lifecycle.LiveData
import com.example.todoey.MyApplication
import com.example.todoey.model.data.task.Task
import com.example.todoey.model.data.task.TaskDB
import com.example.todoey.model.data.task.TaskDao

class TaskRepository {

    private val taskDao: TaskDao = TaskDB.getDatabase(MyApplication.getContext()).taskDao()

    suspend fun addTaskToRoomDb(task : Task){
        taskDao.addTask(task)
    }

    val getAllTaskFromRoomDB : LiveData<List<Task>> = taskDao.getAllTasks()
}