package com.example.todoey.ui.home.allTasksFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoey.model.data.task.Task
import com.example.todoey.model.repository.TaskRepository
import kotlinx.coroutines.launch

class AllTasksViewModel : ViewModel() {
    private val repository : TaskRepository = TaskRepository()

    fun getTasks() :ArrayList<Task>  {
        return repository.getAllTasks()
    }
}