package com.santiagotorres.clothify.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santiagotorres.clothify.databinding.FragmentAcercaBinding

class AcercaFragment : Fragment() {
    private lateinit var acercaBinding: FragmentAcercaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        acercaBinding= FragmentAcercaBinding.inflate(inflater,container,false)

        val view= acercaBinding.root
        return view

    }
}