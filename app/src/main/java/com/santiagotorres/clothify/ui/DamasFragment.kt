package com.santiagotorres.clothify.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santiagotorres.clothify.databinding.FragmentDamasBinding
import com.santiagotorres.clothify.ui.ProductActivity

class DamasFragment : Fragment() {
    private lateinit var damasBinding: FragmentDamasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        damasBinding= FragmentDamasBinding.inflate(inflater,container,false)

        damasBinding.imageView.setOnClickListener {
            val intent = Intent(activity, ProductActivity::class.java)
            startActivity(intent)
        }

        val view= damasBinding.root
        return view
    }
}