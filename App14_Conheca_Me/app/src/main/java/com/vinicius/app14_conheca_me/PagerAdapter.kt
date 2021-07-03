package com.vinicius.app14_conheca_me

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> SobreFragment()
            1 -> FormacaoFragment()
            2 -> ExperienciaFragment()
            else -> DiferenciasFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Sobre"
            1 -> "Formação"
            2 -> "Experiência"
            else -> "Diferencias"
        }
    }
}