package com.example.registrationdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initial values & variable
        var profile_image:de.hdodenhof.circleimageview.CircleImageView? = null
        val etx_first_name:EditText = findViewById(R.id.etx_first_name)
        val etx_last_name:EditText = findViewById(R.id.etx_last_name)
        val etx_email:EditText = findViewById(R.id.etx_email)
        val bu_continue:Button = findViewById(R.id.bu_continue)
        val bu_getPhoto:Button = findViewById(R.id.bu_getPhoto)
        profile_image = findViewById(R.id.profile_image)

        //get photo from your phone
        val getContent: ActivityResultLauncher<String> = registerForActivityResult(
            ActivityResultContracts.GetContent(),ActivityResultCallback{
                if (it != null){
                    profile_image?.setImageURI(it)
                }
            }
        )




        // set function buttons
        bu_getPhoto.setOnClickListener {
            getContent.launch("image/*")
        }


        bu_continue.setOnClickListener {
            val intent = Intent(baseContext,MyProfile::class.java)
            intent.putExtra("profile_image",profile_image.toString())
            intent.putExtra("etx_first_name",etx_first_name.text.toString())
            intent.putExtra("etx_last_name",etx_last_name.text.toString())
            intent.putExtra("etx_email",etx_email.text.toString())
            startActivity(intent)

        }




    }


}