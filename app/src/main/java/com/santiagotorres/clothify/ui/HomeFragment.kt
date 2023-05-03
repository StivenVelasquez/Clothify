package com.santiagotorres.clothify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.santiagotorres.clothify.R
import com.santiagotorres.clothify.databinding.FragmentHomeBinding
import com.santiagotorres.clothify.ui.main.SectionsPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var perfilBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        perfilBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = perfilBinding.root

        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), childFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.tabLayout)
        tabs.setupWithViewPager(viewPager)

        return view
    }
}