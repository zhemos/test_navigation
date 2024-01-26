package com.zm.testnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zm.testnavigation.core.Navigator
import com.zm.testnavigation.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity(), Navigator.Listener {
    private lateinit var binding: ActivityAppBinding
    private val app: App get() = application as App
    private val navigator = Navigator(this, R.id.container)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navigator.add(supportFragmentManager, R.id.container, Screen.BottomNavigation)
        onNavigated(Screen.BottomNavigation)
    }

    override fun onResume() {
        super.onResume()
        navigator.setNavigationListener(this)
    }

    override fun onPause() {
        navigator.removeNavigationListener()
        super.onPause()
    }

    override fun onNavigated(screen: Screen) {
        supportActionBar?.title = screen.title
        supportActionBar?.setDisplayHomeAsUpEnabled(screen.isShowBack)
    }
}