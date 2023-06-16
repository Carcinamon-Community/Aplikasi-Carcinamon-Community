package com.hamdanfatah.carcinamoncommunitycapstone.Artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamdanfatah.carcinamoncommunitycapstone.R
import java.util.*
import kotlin.collections.ArrayList

class ArtikelActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        recyclerView = findViewById(R.id.recycler_view)
        searchView = findViewById(R.id.search_view)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addDataToList()

        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        adapter.onItemClick= {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("food", it)
            startActivity(intent)
        }

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {
        if(query!=null){
            val filteredList = ArrayList<LanguageData>()
            for (i in mList){
                if (i.tittle.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(this, "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filteredList)
            }
        }

    }

    private fun addDataToList() {
        mList.add(
            LanguageData("Andhika Hartawan: Perjalanan Inspiratif Seorang Survivor Kanker", "Kanker adalah kata yang menimbulkan ketakutan dan ketidakpastian bagi banyak orang. Ini adalah pertempuran yang menguji kekuatan, ketahanan, dan keinginan seseorang. Di tengah tantangan yang menakutkan seperti itu, ada individu yang bangkit melampaui kesulitan dan menjadi cahaya harapan dan inspirasi. Salah satu orang tersebut adalah Andhika Hartawan, seorang individu luar biasa yang berhasil mengatasi kanker dan menjadi simbol keberanian dan tekad.\n" +
                "\n" +
                "Perjalanan Andhika dimulai ketika ia didiagnosis kanker pada usia muda. Berita tersebut menghancurkan, dan itu mengubah hidupnya dengan cara yang tidak pernah ia bayangkan. Namun, alih-alih terpuruk dalam keputusasaan, Andhika membuat keputusan untuk melawan dengan segenap kekuatannya. Ia memulai pertempuran yang penuh keberanian, bersenjatakan harapan, kepositifan, dan semangat yang tak tergoyahkan.\n" +
                "\n" +
                "Sepanjang perawatan, Andhika menghadapi banyak tantangan. Rasa sakit fisik, gejolak emosional, dan ketidakpastian akan masa depan sangat berat baginya. Namun, ia tidak pernah kehilangan tujuannya - untuk mengalahkan kanker dan merebut kembali hidupnya. Perjalanan Andhika ditandai dengan kunjungan berulang ke rumah sakit, operasi, dan perawatan medis yang intens. Namun, ia menolak membiarkan kanker mendefinisikan dirinya. Ia menjadi peserta aktif dalam penyembuhannya sendiri, mencari terapi pendukung, mengadopsi gaya hidup sehat, dan mengapresiasi kekuatan kepositifan.\n" +
                "\n" +
                "Kekuatan dan ketekunan Andhika membuahkan hasil ketika ia perlahan-lahan keluar sebagai pemenang. Perawatannya berhasil, dan ia memasuki masa remisi. Namun, ceritanya tidak berakhir di situ. Alih-alih melanjutkan hidupnya seperti biasa, Andhika memutuskan untuk menggunakan pengalamannya untuk membuat perbedaan dalam kehidupan orang lain yang berjuang melawan kanker. Ia menjadi pembela kesadaran kanker, berbagi kisahnya untuk menginspirasi dan memotivasi mereka yang menghadapi tantangan serupa. Melalui ceramah publik, platform media sosial, dan kelompok dukungan, Andhika telah menyentuh hati banyak orang, memberikan mereka harapan dan bahu untuk bersandar.\n" +
                "\n" +
                "Perjalanan Andhika sebagai seorang survivor kanker telah mengajarkannya pelajaran berharga dalam kehidupan - pentingnya rasa syukur, kekuatan ketahanan, dan kekuatan yang ada di dalam diri kita. Ia telah menjadi simbol harapan, mengingatkan kita bahwa tidak peduli seberapa sulit jalan yang kita hadapi, selalu ada sinar cahaya di ujung terowongan. Cerita Andhika adalah bukti nyata tentang semangat manusia yang tak terkalahkan dan kemampuan untuk mengatasi hambatan bahkan yang paling sulit",R.drawable.img)
        )
        mList.add(
            LanguageData("Zoleka Mandela: Membangkitkan Semangat dan Perjuangan Melawan Kanker", "Zoleka Mandela, cucu dari ikon perjuangan anti-apartheid, Nelson Mandela, memiliki kisah perjuangan yang menginspirasi dalam melawan  kanker. Zoleka, seorang pembela hak-hak perempuan dan aktivis sosial, menghadapi tantangan besar ketika ia didiagnosis menderita kanker payudara pada usia yang relatif muda.\n" +
                "\n" +
                "Kisah perjuangan Zoleka dimulai ketika ia merasa benjolan pada payudaranya. Dalam menghadapi ketakutan dan kecemasan, Zoleka mengambil langkah berani untuk menjalani pemeriksaan medis yang mengonfirmasi bahwa ia mengidap kanker payudara stadium lanjut. Namun, dia menolak untuk menyerah pada penyakitnya.\n" +
                "\n" +
                "Zoleka menjalani perawatan intensif, termasuk operasi pengangkatan tumor, kemoterapi, dan radioterapi. Selama proses perawatan, ia mengalami tantangan fisik, emosional, dan mental yang besar. Namun, dengan tekad yang kuat dan dukungan dari keluarga serta komunitasnya, Zoleka menunjukkan ketabahan yang luar biasa.\n" +
                "\n" +
                "Selama masa perjuangannya, Zoleka berbagi kisahnya secara terbuka dengan publik melalui media sosial dan berbagai platform. Dia menggunakan platformnya untuk meningkatkan kesadaran tentang kanker dan pentingnya deteksi dini. Melalui cerita inspiratifnya, Zoleka mendorong orang lain untuk mengambil langkah-langkah pencegahan dan memeriksakan diri secara teratur.\n" +
                "\n" +
                "Meskipun menghadapi berbagai rintangan, Zoleka tidak pernah menyerah pada harapan dan semangat hidup. Dia terus berjuang untuk kesembuhan dan berperan aktif dalam mendukung orang-orang lain yang juga terkena dampak kanker. Zoleka menunjukkan ketabahan, keteguhan, dan semangat yang menginspirasi banyak orang di seluruh dunia.\n" +
                "\n" +
                "Kisah perjuangan Zoleka Mandela adalah bukti nyata bahwa kanker bukanlah akhir dari segalanya. Dengan sikap mental yang positif, dukungan yang tepat, dan tekad yang kuat, kita dapat mengatasi tantangan dan menemukan kekuatan untuk melawan penyakit yang mematikan ini. Zoleka Mandela adalah simbol keberanian dan inspirasi bagi banyak orang yang berjuang melawan kanker dan tantangan hidup lainnya.", R.drawable.img2)
        )

        mList.add(
            LanguageData("Kareem Abdul-Jabbar: Menaklukkan Kanker dan Menyemai Inspirasi", "Kareem Abdul-Jabbar adalah seorang ikon dalam dunia olahraga, terutama dalam dunia bola basket. Selain prestasinya yang gemilang di lapangan, Kareem juga memiliki kisah inspiratif sebagai seorang penyintas kanker.\n" +
                "\n" +
                "Pada tahun 2008, Kareem Abdul-Jabbar didiagnosis menderita kanker prostat. Diawali dengan rasa kaget dan kekhawatiran, Kareem mengambil langkah-langkah berani untuk menghadapi penyakit yang menyerangnya. Dia segera memulai perjalanan pengobatan yang intensif dan menjalani prosedur medis yang diperlukan.\n" +
                "\n" +
                "Dalam perjalanan pengobatan, Kareem Abdul-Jabbar menunjukkan ketabahan dan semangat yang luar biasa. Meskipun mengalami tantangan fisik dan emosional, dia tidak pernah menyerah. Kareem aktif terlibat dalam mencari informasi dan mempelajari berbagai cara untuk mendukung proses penyembuhannya.\n" +
                "\n" +
                "Selama menghadapi kanker, Kareem Abdul-Jabbar juga menggunakan platformnya sebagai seorang publik figur untuk menyebarkan kesadaran tentang pentingnya deteksi dini dan perawatan yang tepat. Dia berbagi pengalamannya melalui berbagai wawancara, artikel, dan buku yang menginspirasi banyak orang di seluruh dunia.\n" +
                "\n" +
                "Kareem Abdul-Jabbar berhasil melawan kanker prostatnya dan menjadi penyintas yang kuat. Kisahnya menjadi inspirasi bagi banyak orang yang sedang berjuang melawan penyakit mematikan ini. Dia membuktikan bahwa dengan semangat yang kuat, dukungan yang tepat, dan ketekunan, kita bisa menghadapi dan mengalahkan tantangan terbesar dalam hidup kita.\n" +
                "\n" +
                "Kisah inspiratif Kareem Abdul-Jabbar sebagai seorang penyintas kanker mengajarkan kita tentang pentingnya menjaga semangat, ketabahan, dan harapan dalam menghadapi tantangan hidup. Dia tidak hanya menjadi contoh inspiratif bagi para penderita kanker, tetapi juga bagi semua orang yang menghadapi cobaan dalam hidup mereka. Kareem Abdul-Jabbar memberikan teladan bahwa kita tidak boleh menyerah dan terus berjuang untuk hidup yang lebih baik.", R.drawable.img3)
        )


    }
}