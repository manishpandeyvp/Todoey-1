package com.example.todoey.ui.home.addTaskFragment

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoey.R
import com.example.todoey.model.data.task.Task
import com.example.todoey.model.repository.TaskRepository
import kotlinx.coroutines.launch

class AddTaskViewModel : ViewModel() {

    private val repository: TaskRepository = TaskRepository()
    var title: String = ""
    var body: String = ""
    var pinned: Boolean = false
    var color: Int = R.color.orange

    private fun addTask(task: Task) {
        viewModelScope.launch {
            repository.addTaskToRoomDb(task)
        }
    }

    fun onPinnedChanged() {
        pinned = !pinned
        Log.d("MANISH", "pinned : $pinned")
    }

    fun addTask() {
//        val task = Task(1, title, body, pinned, color)
//        addTask(task)
        Log.d("MANISH", "ADD TASK CLICKED")
    }

    fun colorPicker(view: View) {
        Log.d("MANISH", "${view.id}")
    }

//    TODO: how to pass a function in data binding... for color picking and others as well

}