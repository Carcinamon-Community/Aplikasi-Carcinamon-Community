package com.hamdanfatah.carcinamoncommunitycapstone

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginEmailActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var disiniRegister: TextView
    lateinit var progressDialog: ProgressDialog


    var firebaseAuth = FirebaseAuth.getInstance()



    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser!=null){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_email)


        etEmail = findViewById(R.id.email_login)
        etPassword = findViewById(R.id.password_login)
        btnLogin = findViewById(R.id.btn_login)
        disiniRegister = findViewById(R.id.disini_register)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Silahkan Tunggu...")

        btnLogin.setOnClickListener {
            if (etEmail.text.isNotEmpty() && etPassword.text.isNotEmpty()){
                processLogin()

            }else{
                Toast.makeText(this, "Silahkan isi Email dan Kata Sandi terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        disiniRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    private fun processLogin() {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
            .addOnFailureListener {error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {
                progressDialog.dismiss()
            }
    }
}