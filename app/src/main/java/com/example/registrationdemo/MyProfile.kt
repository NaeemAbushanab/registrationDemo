package com.example.registrationdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.registrationdemo.databinding.ActivityMyProfileBinding

class MyProfile : AppCompatActivity() {
    private lateinit var binding:ActivityMyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shared: SharedPreferences = getSharedPreferences("com.example.registrationdemo", MODE_PRIVATE)

        binding.savedEmailTextView.text = shared.getString("email","")
        binding.savedFullNameTextView.text = shared.getString("fullName","")

        binding.logoutButton.setOnClickListener{
            val editor:SharedPreferences.Editor = shared.edit()
            val intent = Intent(baseContext, RegistrationPage::class.java)

            editor.clear()
            editor.apply()
            startActivity(intent)

        }






    }
}