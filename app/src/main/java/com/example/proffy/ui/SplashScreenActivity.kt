package com.eder.proffy.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.eder.proffy.databinding.ActivitySplashScreenBinding
import com.eder.proffy.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}