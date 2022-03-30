package com.benny.trelloclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class SignUpActivity : AppCompatActivity() {

    var sign_up_toolbar:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        sign_up_toolbar = findViewById(R.id.toolbar_sign_up_activity)
        setupActionBar()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }



    private fun setupActionBar(){
        setSupportActionBar(sign_up_toolbar)

        val actionBar = supportActionBar
        if (actionBar!= null) {

            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        sign_up_toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}