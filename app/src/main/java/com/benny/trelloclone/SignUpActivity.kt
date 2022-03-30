package com.benny.trelloclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class SignUpActivity : AppCompatActivity() {

    var sign_up_toolbar:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        sign_up_toolbar = findViewById(R.id.sign_up_toolbar)
        setupActionBar()
    }



    private fun setupActionBar(){
        setSupportActionBar(sign_up_toolbar)

        val actionBar = supportActionBar
        if (actionBar!= null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        }
    }
}