package com.example.registrationdemo

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MyProfile : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        var myProfileActivity_profile_image:de.hdodenhof.circleimageview.CircleImageView? = null
        myProfileActivity_profile_image = findViewById(R.id.myProfileActivity_profile_image)
        val tx_name:TextView = findViewById(R.id.tx_name)
        val tx_email:TextView = findViewById(R.id.tx_email)

        tx_name.text = "${intent.getStringExtra("etx_first_name")} ${intent.getStringExtra("etx_last_name")}"
        tx_email.text = intent.getStringExtra("etx_email")



    }
}