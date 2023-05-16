package com.santiagotorres.clothify.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.santiagotorres.clothify.Manifest
import com.santiagotorres.clothify.databinding.FragmentPerfilBinding
import com.santiagotorres.clothify.ui.signin.SignInActivity


class PerfilFragment : Fragment() {

    private lateinit var perfilBinding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val PerfilViewModel = ViewModelProvider(this)[PerfilViewModel::class.java]
       perfilBinding=FragmentPerfilBinding.inflate(inflater,container,false)
        val view=perfilBinding.root

        PerfilViewModel.loadUserInfo()

        PerfilViewModel.errorMsg.observe(viewLifecycleOwner){errorMsg ->
            Toast.makeText(requireActivity(), errorMsg, Toast.LENGTH_LONG).show()
        }

        PerfilViewModel.userLoaded.observe(viewLifecycleOwner){user ->
            with(perfilBinding){
                textViewName.text = user?.name
                textViewEmail.text = user?.email

            }
        }

        perfilBinding.signOutButton.setOnClickListener{
            Firebase.auth.signOut()
            val intent = Intent(activity, SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }



        return view
    }



}