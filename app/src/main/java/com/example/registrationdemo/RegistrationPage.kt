package com.example.registrationdemo

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.registrationdemo.databinding.ActivityRegistrationPageBinding
import kotlin.system.exitProcess


class RegistrationPage : AppCompatActivity() {
    private lateinit var binding:ActivityRegistrationPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationPageBinding.inflate(layoutInflater)
        val shared: SharedPreferences =
            getSharedPreferences("com.example.registrationdemo", MODE_PRIVATE)

        if (shared.getBoolean("isLogin", false))

            navToMyProfile()

        else
            setContentView(binding.root)


        //get photo from your phone
        val getContent: ActivityResultLauncher<String> = registerForActivityResult(
            ActivityResultContracts.GetContent(), ActivityResultCallback {
                if (it != null) {
                    binding.profileImageView.setImageURI(it)
                }
            }
        )


        // set function buttons
        binding.profileImageView.setOnClickListener {
            getContent.launch("image/*")
        }
        binding.saveButton.setOnClickListener {
            getContent.launch("image/*")
        }


        binding.saveButton.setOnClickListener {

            val editor: SharedPreferences.Editor = shared.edit()

            editor.putString(
                "fullName",
                "${binding.firstNameEditText.text} ${binding.lastNameEditText.text}"
            )

            editor.putString("email", "${binding.emailEditText.text}")
            editor.putBoolean("isLogin", true)

            editor.apply()

            Toast.makeText(this, "Saved login information", Toast.LENGTH_LONG).show()
            navToMyProfile()



        }


    }

    private fun navToMyProfile(){
        val intent = Intent(baseContext, MyProfile::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        moveTaskToBack(true);
        exitProcess(-1)
    }
}