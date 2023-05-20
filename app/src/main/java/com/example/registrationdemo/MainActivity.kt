package com.example.registrationdemo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shared: SharedPreferences =
            getSharedPreferences("com.example.registrationdemo", MODE_PRIVATE)

        if (shared.getBoolean("isLogin", false)) {
            val intent = Intent(baseContext, MyProfile::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(baseContext, RegistrationPage::class.java)
            startActivity(intent)
        }

    }
}

