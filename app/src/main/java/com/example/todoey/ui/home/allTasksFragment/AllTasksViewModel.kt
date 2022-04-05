package com.example.todoey.ui.home.allTasksFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todoey.model.data.task.Task
import com.example.todoey.model.repository.FactRepository
import com.example.todoey.model.repository.TaskRepository

class AllTasksViewModel : ViewModel() {
    private val repository : TaskRepository = TaskRepository()
    private val factRepository : FactRepository = FactRepository()

    fun getTasks() :LiveData<List<Task>>  {
        return repository.getAllTaskFromRoomDB
    }

    suspend fun getFact() : String? {
        return factRepository.getFact()
    }

    fun getPinnedTasks() : LiveData<List<Task>> {
        return repository.getPinnedTask
    }
}