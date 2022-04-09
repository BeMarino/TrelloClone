package com.benny.trelloclone.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.benny.trelloclone.R
import com.benny.trelloclone.firebase.FirestoreClass
import com.benny.trelloclone.models.User
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : BaseActivity() {
    private var sign_in_toolbar: Toolbar? = null
    private lateinit var et_email: EditText
    private lateinit var et_password: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var btn_sign_in: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        sign_in_toolbar = findViewById(R.id.toolbar_sign_in_activity)
        setupActionBar()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        et_email = findViewById(R.id.sign_in_et_email)
        et_password = findViewById(R.id.sign_in_et_password)

        btn_sign_in = findViewById(R.id.btn_sign_in)
        btn_sign_in.setOnClickListener { signInRegisteredUser() }
    }


                    }
                }

        }
    }

    private fun setupActionBar() {
        setSupportActionBar(sign_in_toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {

            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        sign_in_toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}