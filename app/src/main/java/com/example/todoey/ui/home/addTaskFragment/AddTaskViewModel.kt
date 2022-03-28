package com.example.todoey.ui.home.addTaskFragment

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoey.data.task.Task
import com.example.todoey.data.task.TaskDB
import com.example.todoey.repository.TaskRepository
import kotlinx.coroutines.launch

class AddTaskViewModel(application: Application) : AndroidViewModel(application) {

//    private val repository: TaskRepository

    init {
        val memberDao = TaskDB.getDatabase(application).taskDao()
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
        }
    }
}