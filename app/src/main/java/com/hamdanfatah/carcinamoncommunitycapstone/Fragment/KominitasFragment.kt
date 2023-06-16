package com.hamdanfatah.carcinamoncommunitycapstone.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.hamdanfatah.carcinamoncommunitycapstone.R



class KominitasFragment : Fragment() {

    lateinit var tanya: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kominitas, container, false)

    tanya = view!!.findViewById(R.id.tanya)



        tanya.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_navigation_komunitas_to_pertanyaanActivity)
        }




    }


}