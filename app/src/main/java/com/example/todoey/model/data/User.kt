package com.example.todoey.model.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

data class User(
    var uid: String,
    var username: String,
    var email : String,
)
