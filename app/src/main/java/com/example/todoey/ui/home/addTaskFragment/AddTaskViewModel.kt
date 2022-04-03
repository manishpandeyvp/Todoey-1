package com.example.todoey.ui.home.addTaskFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoey.model.data.task.Task
import com.example.todoey.model.repository.TaskRepository
import kotlinx.coroutines.launch

class AddTaskViewModel : ViewModel(){

    private val repository : TaskRepository = TaskRepository()

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.addTaskToRoomDb(task)
        }
    }

}