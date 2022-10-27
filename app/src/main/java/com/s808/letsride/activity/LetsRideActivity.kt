package com.s808.letsride.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.s808.letsride.ui.LetsRideApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LetsRideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LetsRideApp()
        }
    }
}
