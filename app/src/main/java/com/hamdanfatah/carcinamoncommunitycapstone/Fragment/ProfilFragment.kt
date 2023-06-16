package com.hamdanfatah.carcinamoncommunitycapstone.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hamdanfatah.carcinamoncommunitycapstone.LoginActivity
import com.hamdanfatah.carcinamoncommunitycapstone.R


class ProfilFragment : Fragment() {
    private lateinit var btn_keluar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
        btn_keluar.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
        }


    }


}