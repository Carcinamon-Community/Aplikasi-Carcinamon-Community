package com.hamdanfatah.carcinamoncommunitycapstone.Artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.hamdanfatah.carcinamoncommunitycapstone.R

class DetailActivity : AppCompatActivity() {
    private lateinit var btnBack:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnBack = findViewById(R.id.btn_back_detail)

        btnBack.setOnClickListener{
            startActivity(Intent(this, ArtikelActivity::class.java))
        }

        val food = intent.getParcelableExtra<LanguageData>("food")
        if (food!=null){
            val judul: TextView = findViewById(R.id.tv_detail_judul)
            val deskripsi: TextView = findViewById(R.id.tv_detail_deskripsi)
            val gambar: ImageView= findViewById(R.id.iv_detail_artikel)

            judul.text = food.tittle
            deskripsi.text = food.deskripsi
            gambar.setImageResource(food.logo)
        }
    }


}