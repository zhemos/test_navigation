package com.zm.testnavigation

import android.app.Application
import com.zm.testnavigation.core.Navigator

class App : Application() {
//    private var _navigator: Navigator? = null
//    val navigator: Navigator get() = _navigator ?: error("navigator error")

    override fun onCreate() {
        super.onCreate()
//        _navigator = Navigator()
    }
}