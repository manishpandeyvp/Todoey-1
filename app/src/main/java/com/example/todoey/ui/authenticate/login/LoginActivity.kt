package com.example.todoey.ui.authenticate.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoey.R
import com.example.todoey.ui.authenticate.signup.SignupActivity
import com.example.todoey.ui.home.HomeActivity
import com.example.todoey.utils.Constants
import com.example.todoey.utils.Internet
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

lateinit var sharedPreference: SharedPreferences

class LoginActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreference = getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE)
        with(sharedPreference.edit()){
            putBoolean(Constants.IS_CONNECTED_TO_INTERNET, Internet.hasInternetConnectivity(this@LoginActivity))
            apply()
        }
    }

    override fun onResume() {
        super.onResume()

        btn_signup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        btn_login.setOnClickListener {
            val email = ev_email.text.toString()
            val pass = ev_password.text.toString()

            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    startActivity(Intent(this, HomeActivity::class.java))
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}