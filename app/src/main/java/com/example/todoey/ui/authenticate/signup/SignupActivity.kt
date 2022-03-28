package com.example.todoey.ui.authenticate.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoey.R
import com.example.todoey.data.User
import com.example.todoey.ui.authenticate.login.LoginActivity
import com.example.todoey.ui.home.HomeActivity
import com.example.todoey.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    override fun onResume() {
        super.onResume()
        btn_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_signup.setOnClickListener {
            val username: String = ev_username.text.toString()
            val email: String = ev_email.text.toString()
            val pass: String = ev_password.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = User(getCurrentUserUID(), username, email)
                    db.collection(Constants.USER).add(user).addOnCompleteListener {
                        if (task.isSuccessful) {
                            Toast.makeText(
                                application,
                                "Registration Successful",
                                Toast.LENGTH_LONG
                            ).show()
                            startActivity(Intent(this, HomeActivity::class.java))
                        }
                    }
                } else {
                    Toast.makeText(
                        application,
                        "Registration Failed ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
    }


    private fun getCurrentUserUID(): String {
        val currentUser = firebaseAuth.currentUser
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }
}