package com.benny.trelloclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class IntroActivity : AppCompatActivity() {

    var btn_sign_up:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        btn_sign_up = findViewById(R.id.btn_sign_up_intro)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_up?.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

    }
}