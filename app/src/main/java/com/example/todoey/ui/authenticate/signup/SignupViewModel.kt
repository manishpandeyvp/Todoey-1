package com.example.todoey.ui.authenticate.signup

import androidx.lifecycle.ViewModel
import com.example.todoey.model.repository.AuthRepository

class SignupViewModel : ViewModel() {

    private val repository: AuthRepository = AuthRepository()

    fun signUp(username: String, email: String, pass: String) {
        repository.firebaseRegisterUserWithEmailAndPass(username, email, pass)
    }
}