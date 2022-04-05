package com.example.todoey.model.data.task

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert(onConflict = IGNORE)
    suspend fun addTask(task: Task)

    @Query("SELECT * FROM task_list ORDER BY id ASC")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM TASK_LIST WHERE pinned = :pinned ORDER BY id ASC")
    fun getPinnedTask(pinned : Boolean) : LiveData<List<Task>>

}