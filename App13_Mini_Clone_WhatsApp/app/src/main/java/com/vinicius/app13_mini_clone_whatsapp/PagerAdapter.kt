package com.vinicius.app13_mini_clone_whatsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            ConversasFragment()
        else if (position == 1)
            StatusFragment()
        else
            ChamadasFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Conversa"
        else if (position == 1)
            "Status"
        else
            "Chamadas"
    }

}
