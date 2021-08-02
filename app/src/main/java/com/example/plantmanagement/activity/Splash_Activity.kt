package com.example.plantmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.plantmanagement.R


class Splash_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@Splash_Activity, MainActivity::class.java))
            finish()
        }, 3000)
    }
}