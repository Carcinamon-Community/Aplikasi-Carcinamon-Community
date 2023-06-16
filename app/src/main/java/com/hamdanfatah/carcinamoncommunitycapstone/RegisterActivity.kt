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
import com.google.firebase.auth.ktx.userProfileChangeRequest

class RegisterActivity : AppCompatActivity() {
    lateinit var etFullname: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnRegister: Button
    lateinit var disiniLogin: TextView
    lateinit var etPassowordConf:EditText

    lateinit var progressDialog: ProgressDialog

    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser!=null){
            startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etFullname = findViewById(R.id.fullname)
        etEmail = findViewById(R.id.email)
        etPassword = findViewById(R.id.password)
        btnRegister = findViewById(R.id.btn_kirim)
        disiniLogin = findViewById(R.id.disini_login)
        etPassowordConf = findViewById(R.id.password_conf)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Logging")
        progressDialog.setMessage("Silahkan Tunggu...")



        //val userEmail = etEmail.text.toString()

        disiniLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            if (etFullname.text.isNotEmpty() && etPassword.text.isNotEmpty() && etEmail.text.isNotEmpty() && etPassowordConf.text.isNotEmpty()){
                if (etPassword.text.toString() == etPassowordConf.text.toString()){
                    processRegister()


                }else{
                    Toast.makeText(this, " Kata sandi harus sama", Toast.LENGTH_SHORT ).show()
                }

            }else{
                Toast.makeText(this,"Silahkan isi semua datanya dengan benar!", Toast.LENGTH_SHORT).show()
            }
        }



    }



    //private fun isValidEmail(email: String): Boolean {
    //    val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    //    return email.matches(emailPattern)
    //}

    private fun processRegister(){
        val fullname = etFullname.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        progressDialog.show()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val userUpdateProfile = userProfileChangeRequest {
                        displayName = fullname
                    }
                    val user = task.result.user
                    user!!.updateProfile(userUpdateProfile)
                        .addOnCompleteListener {
                            progressDialog.dismiss()
                            startActivity(Intent(this, LoginActivity::class.java))
                        }
                        .addOnFailureListener {error2 ->
                            Toast.makeText(this, error2.localizedMessage, Toast.LENGTH_SHORT).show()


                        }

                }else{
                    progressDialog.dismiss()
                }
            }
            .addOnFailureListener { error ->
                progressDialog.dismiss()
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()

            }

    }

}