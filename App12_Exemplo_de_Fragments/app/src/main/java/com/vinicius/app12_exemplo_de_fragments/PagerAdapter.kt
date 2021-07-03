package com.vinicius.app12_exemplo_de_fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            Fragment01()
        else
            Fragment02()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Conversa"
        else
            "Status"
    }

}
