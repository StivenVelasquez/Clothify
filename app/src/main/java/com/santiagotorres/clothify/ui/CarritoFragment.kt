package com.santiagotorres.clothify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.santiagotorres.clothify.databinding.FragmentCarritoBinding

class CarritoFragment : Fragment() {

    private lateinit var carritoBinding: FragmentCarritoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        carritoBinding=FragmentCarritoBinding.inflate(inflater,container,false)

        carritoBinding.comprarButton.setOnClickListener{
            Snackbar.make(carritoBinding.LinearLayout,"Compra exitosa", Snackbar.LENGTH_INDEFINITE).setAction("Aceptar"){
            }
                .show()
        }

        val view= carritoBinding.root
        return view
    }
}