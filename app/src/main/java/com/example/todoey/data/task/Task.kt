package com.example.todoey.data.task

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoey.data.User
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task_list")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var body: String,
    var created_by: String,
    var assigned_to: String
) : Parcelable