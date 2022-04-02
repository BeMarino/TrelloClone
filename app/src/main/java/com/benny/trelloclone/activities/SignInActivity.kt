package com.benny.trelloclone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import com.benny.trelloclone.R

class SignInActivity : AppCompatActivity() {
    var sign_in_toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        sign_in_toolbar = findViewById(R.id.toolbar_sign_in_activity)
        setupActionBar()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }



    private fun setupActionBar(){
        setSupportActionBar(sign_in_toolbar)

        val actionBar = supportActionBar
        if (actionBar!= null) {

            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        sign_in_toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}