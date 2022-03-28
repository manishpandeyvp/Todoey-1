package com.example.todoey.ui.authenticate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todoey.R
import com.example.todoey.ui.authenticate.login.LoginFragment
import com.example.todoey.ui.authenticate.signup.SignupFragment
import kotlinx.android.synthetic.main.login_fragment.btn_signup
import kotlinx.android.synthetic.main.signup_fragment.btn_login

class AuthenticateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticate)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_auth, LoginFragment()).commit()


    }

    override fun onResume() {
        super.onResume()
        btn_signup.setOnClickListener {
            Log.d("MANISH", "signupClicked")
            supportFragmentManager.beginTransaction().replace(R.id.fragment_auth, SignupFragment()).commit()
        }

        btn_login.setOnClickListener {
            Log.d("MANISH", "loginClicked")
            supportFragmentManager.beginTransaction().replace(R.id.fragment_auth, LoginFragment()).commit()
        }
    }
}