package com.zm.testnavigation.core

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.zm.testnavigation.Screen

class Navigator(
    private val activity: FragmentActivity,
    private val containerId: Int,
    private val fragmentManager: FragmentManager = activity.supportFragmentManager
) {

    private var listener: Listener? = null

    fun setNavigationListener(listener: Listener) {
        this.listener = listener
    }

    fun removeNavigationListener() {
        listener = null
    }

    fun add(fm: FragmentManager, containerId: Int, screen: Screen) {
        fm.beginTransaction()
            .add(containerId, screen.fragment, screen.fragment.customTag)
            .commit()
        update(screen)
    }

    fun replace(fm: FragmentManager, containerId: Int, screen: Screen) {
        fm.beginTransaction()
            .replace(containerId, screen.fragment, screen.fragment.customTag)
            .commit()
        update(screen)
    }

    private fun update(screen: Screen) {
        Log.d("zm1996", "$screen")
        listener?.onNavigated(screen)
    }

    interface Listener {
        fun onNavigated(screen: Screen)
    }
}