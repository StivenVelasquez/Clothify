package com.santiagotorres.clothify.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.santiagotorres.clothify.R
import com.santiagotorres.clothify.ui.CaballerosFragment
import com.santiagotorres.clothify.ui.DamasFragment
import com.santiagotorres.clothify.ui.ninos.RopaNinosFragment

private val TAB_TITLES = arrayOf(
    R.string.damas,
    R.string.caballeros,
    R.string.ninos,
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> return DamasFragment()
            1-> return CaballerosFragment()
            else->return RopaNinosFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}