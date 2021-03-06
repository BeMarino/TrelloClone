package com.benny.trelloclone.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.TextView
import com.benny.trelloclone.R
import com.benny.trelloclone.firebase.FirestoreClass

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val tv_app_name: TextView = findViewById(R.id.tv_app_name)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val typeface: Typeface = Typeface.createFromAsset(assets, "Montserrat-Regular.ttf")
        tv_app_name.typeface = typeface

        Handler().postDelayed({

            var currentUserId = FirestoreClass().getCurrentUserId()

            if (currentUserId.isNotEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))

            } else {
                startActivity(Intent(this, IntroActivity::class.java))

            }

        }, 2500)
    }
}