package com.zm.testnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.google.android.material.navigation.NavigationBarView
import com.zm.testnavigation.core.BaseFragment
import com.zm.testnavigation.databinding.FragmentBotNavBinding

class BottomNavigationFragment : BaseFragment<FragmentBotNavBinding>(),
    NavigationBarView.OnItemSelectedListener {

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBotNavBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavView.setOnItemSelectedListener(this)
    }

    override fun onPause() {
        super.onPause()
        binding.bottomNavView.setOnItemSelectedListener(null)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

        }
        return true
    }

    companion object {

        fun getNewInstance(): BottomNavigationFragment {
            return BottomNavigationFragment()
        }
    }

    @JvmInline
    value class My(val d: Double)
}