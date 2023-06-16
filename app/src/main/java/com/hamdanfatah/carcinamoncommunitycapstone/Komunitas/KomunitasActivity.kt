package com.hamdanfatah.carcinamoncommunitycapstone.Komunitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.hamdanfatah.carcinamoncommunitycapstone.R
import com.hamdanfatah.carcinamoncommunitycapstone.model.PertanyaanModel

class KomunitasActivity : AppCompatActivity() {
    private lateinit var tanya:TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var empList: ArrayList<PertanyaanModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_komunitas)

        tanya = findViewById(R.id.tanya)

        tanya.setOnClickListener{
            startActivity(Intent(this, PertanyaanActivity::class.java))
        }

        recyclerView = findViewById(R.id.rv_komunitas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        empList = arrayListOf<PertanyaanModel>()
        getemployee()
    }

    private fun getemployee() {
        dbRef = FirebaseDatabase.getInstance().getReference("post")

        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children ){
                        val empData = empSnap.getValue(PertanyaanModel::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = KomunitasAdapter(empList)
                    recyclerView.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}