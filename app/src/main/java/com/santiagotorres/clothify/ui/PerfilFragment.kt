package com.santiagotorres.clothify.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.santiagotorres.clothify.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {

    private lateinit var perfilBinding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       perfilBinding=FragmentPerfilBinding.inflate(inflater,container,false)
        val view=perfilBinding.root

        return view
    }

}