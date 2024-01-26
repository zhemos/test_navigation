package com.zm.testnavigation

import com.zm.testnavigation.core.BaseFragment
import com.zm.testnavigation.ui.BottomNavigationFragment

sealed interface Screen {
    val fragment: BaseFragment<*>
    val title: String
    val isShowBack: Boolean

    data object BottomNavigation : Screen {
        override val fragment: BaseFragment<*> get() = BottomNavigationFragment.getNewInstance()
        override val title: String get() = "BottomNav"
        override val isShowBack: Boolean get() = false
    }
}