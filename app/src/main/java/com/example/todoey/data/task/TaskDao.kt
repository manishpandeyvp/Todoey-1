package com.example.todoey.data.task

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    suspend fun addTask(task: Task)

    @Query("SELECT * FROM task_list ORDER BY id ASC")
    fun getAllTasks(): LiveData<List<Task>>

}