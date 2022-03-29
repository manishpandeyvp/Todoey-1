package com.example.todoey.model.data.task

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task_list")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    var title: String = "",
    var body: String = "",
    var assigned_to: String = ""
) : Parcelable