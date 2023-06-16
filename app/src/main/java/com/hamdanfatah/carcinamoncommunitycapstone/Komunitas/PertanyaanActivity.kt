package com.hamdanfatah.carcinamoncommunitycapstone.Komunitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hamdanfatah.carcinamoncommunitycapstone.R
import com.hamdanfatah.carcinamoncommunitycapstone.model.PertanyaanModel

class PertanyaanActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var kirim: Button
    private lateinit var etJudulPertanyaan: EditText
    private lateinit var etDeskripsiPertanyaan: EditText
// ...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan)

        database = Firebase.database.reference

        kirim = findViewById(R.id.btn_kirim_pertanyaan)
        etDeskripsiPertanyaan = findViewById(R.id.et_deskripsi_pertanyaan)
        etJudulPertanyaan = findViewById(R.id.et_judul_pertanyaan)

        kirim.setOnClickListener {
            postPertanyaan()
        }



    }

    private fun postPertanyaan() {
        val header: String = etJudulPertanyaan.text.toString().trim()
        val text: String = etDeskripsiPertanyaan.text.toString().trim()

        if (header.isEmpty()){
            etJudulPertanyaan.error = "Isi Judul!"
            return
        }

        if (text.isEmpty()){
            etDeskripsiPertanyaan.error = "Isi Judul!"
            return
        }
        val ref = FirebaseDatabase.getInstance().getReference("post")
        val postID = ref.push().key

        val post = PertanyaanModel(postID,header,text, )

        if (postID != null) {
            ref.child(postID).setValue(post).addOnCompleteListener {
                Toast.makeText(applicationContext, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, KomunitasActivity::class.java))
                etJudulPertanyaan.text.clear()
                etDeskripsiPertanyaan.text.clear()
            }
        }
    }


}