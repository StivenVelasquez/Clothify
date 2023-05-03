package com.santiagotorres.clothify.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.santiagotorres.clothify.databinding.FragmentCaballerosBinding

class CaballerosFragment : Fragment() {
    private lateinit var caballerosBinding: FragmentCaballerosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        caballerosBinding= FragmentCaballerosBinding.inflate(inflater,container,false)

        caballerosBinding.imageView.setOnClickListener {
            val intent = Intent(activity, ProductActivity::class.java)
            startActivity(intent)
        }

        val view= caballerosBinding.root
        return view
    }
}