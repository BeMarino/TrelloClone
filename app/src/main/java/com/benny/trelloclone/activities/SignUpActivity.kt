package com.benny.trelloclone.activities

import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.benny.trelloclone.R
import com.benny.trelloclone.firebase.FirestoreClass
import com.benny.trelloclone.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : BaseActivity() {

    private var sign_up_toolbar: Toolbar? = null

    private lateinit var et_name: TextView
    private lateinit var et_email: TextView
    private lateinit var et_password: TextView

    private lateinit var btn_sign_up: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        sign_up_toolbar = findViewById(R.id.toolbar_sign_up_activity)
        setupActionBar()

        et_name = findViewById<TextView>(R.id.et_name)
        et_email = findViewById<TextView>(R.id.et_email)
        et_password = findViewById<TextView>(R.id.et_password)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_up = findViewById(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener {
            registerUser()
        }
    }


    private fun setupActionBar() {
        setSupportActionBar(sign_up_toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {

            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        sign_up_toolbar?.setNavigationOnClickListener { onBackPressed() }
    }

    private fun registerUser() {
        val name: String = et_name.text.toString().trim()
        val email: String = et_email.text.toString().trim()
        val password: String = et_password.text.toString().trim()

        if (validateForm(name, email, password)) {
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser? = task.result!!.user!!
                        val registeredEmail = firebaseUser!!.email!!
                        val user = User(firebaseUser.uid, name, registeredEmail)
                        FirestoreClass().registerUser(this, user)

                    } else {
                        Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter a name")
                false
            }

            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter an email address")
                false
            }

            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password")
                false
            }
            else -> {

                true
            }
        }
    }

    fun userRegisteredSuccess() {
        Toast.makeText(
            this,
            "You have successfully registered your account",
            Toast.LENGTH_LONG
        ).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        finish()
    }
}