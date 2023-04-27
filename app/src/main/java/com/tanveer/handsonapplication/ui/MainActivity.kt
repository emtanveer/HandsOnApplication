package com.tanveer.handsonapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tanveer.handsonapplication.R
import com.tanveer.handsonapplication.ui.dashboard.presentation.DashboardActivity
import com.tanveer.handsonapplication.utils.NavigationUtils.simpleNavigateTo

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleNavigateTo(this@MainActivity, DashboardActivity::class.java as Class<Any>)
    }
}