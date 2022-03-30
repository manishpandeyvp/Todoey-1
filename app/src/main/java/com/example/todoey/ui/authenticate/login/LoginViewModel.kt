package com.example.todoey.ui.authenticate.login

import androidx.lifecycle.ViewModel
import com.example.todoey.model.repository.AuthRepository

class LoginViewModel : ViewModel() {

    val repository : AuthRepository = AuthRepository()

    fun logIn(email : String, pass : String){
        repository.firebaseLoginUserWithEmailAndPass(email, pass)
    }
}