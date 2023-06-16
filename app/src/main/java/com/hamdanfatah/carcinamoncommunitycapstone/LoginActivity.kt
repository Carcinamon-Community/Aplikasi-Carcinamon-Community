package com.hamdanfatah.carcinamoncommunitycapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class LoginActivity : AppCompatActivity() {
    private lateinit var btnEmail: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEmail = findViewById(R.id.btn_email)

        btnEmail.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}