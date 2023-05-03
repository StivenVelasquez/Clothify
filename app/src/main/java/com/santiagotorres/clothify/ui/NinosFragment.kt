package com.santiagotorres.clothify.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.santiagotorres.clothify.databinding.FragmentNinosBinding

class NinosFragment : Fragment() {

    private lateinit var ninosBinding: FragmentNinosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ninosBinding= FragmentNinosBinding.inflate(inflater,container,false)

        ninosBinding.imageView.setOnClickListener {
            val intent = Intent(activity, ProductActivity::class.java)
            startActivity(intent)
        }
        return ninosBinding.root
    }
}





