package com.example.testflowfragmentlifecycle

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val stateViewModel: StateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val fragment = BlankFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()

        lifecycleScope.launch {
            for (i in 1..10) {
                if (i % 2 != 0) {
                    supportFragmentManager.beginTransaction().detach(fragment)
                        .commitAllowingStateLoss()
                    delay(1000)
                } else {
                    supportFragmentManager.beginTransaction().attach(fragment)
                        .commitAllowingStateLoss()
                    delay(3000)
                }

                stateViewModel.inc()
            }
        }
    }

    fun showFragment(view: View) {

    }
}