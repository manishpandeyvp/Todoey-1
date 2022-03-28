package com.example.todoey.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository(private var application: Application) {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var userMutableLiveData : MutableLiveData<FirebaseUser> = MutableLiveData()

    fun firebaseRegisterUserWithEmailAndPass(email : String, password : String){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(application, "Registration Successful", Toast.LENGTH_LONG).show()
                userMutableLiveData.postValue(firebaseAuth.currentUser)
            }else{
                Toast.makeText(application, "Registration Failed ${task.exception?.message}", Toast.LENGTH_LONG).show()
            }
            Log.d("MANISH", "outside if else in register")
        }
        Log.d("MANISH", "outside firebaseRegister")
    }

    fun getUser() : MutableLiveData<FirebaseUser> {
        Log.d("MANISH", "in getUser fun")
        return userMutableLiveData
    }
}