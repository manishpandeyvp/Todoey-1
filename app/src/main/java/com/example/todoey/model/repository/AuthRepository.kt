package com.example.todoey.model.repository

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.todoey.MyApplication
import com.example.todoey.model.data.User
import com.example.todoey.ui.home.HomeActivity
import com.example.todoey.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AuthRepository {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    fun firebaseRegisterUserWithEmailAndPass(username: String, email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = User(this.getCurrentUserID(), username, email)
                db.collection(Constants.USER).add(user).addOnCompleteListener {
                    if (task.isSuccessful) {
                        Toast.makeText(
                            MyApplication.getContext(),
                            "Registration Successful",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            MyApplication.getContext(),
                            Intent(MyApplication.getContext(), HomeActivity::class.java),
                            null
                        )
                    }
                }
            } else {
                Toast.makeText(
                    MyApplication.getContext(),
                    "Registration Failed ${task.exception?.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun firebaseLoginUserWithEmailAndPass(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                startActivity(
                    MyApplication.getContext(),
                    Intent(MyApplication.getContext(), HomeActivity::class.java),
                    null
                )
                Toast.makeText(MyApplication.getContext(), "Login Successful", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(MyApplication.getContext(), "Login Failed", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun isLoggedIn(): Boolean {
        val currentUser = firebaseAuth.currentUser
        return currentUser != null
    }

    fun getCurrentUserID(): String {
        val currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }
}