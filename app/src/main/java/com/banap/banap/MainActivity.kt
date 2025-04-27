package com.banap.banap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.banap.banap.app.navigation.Navigation
import com.banap.banap.core.ui.theme.BanapTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Banap)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanapTheme {
                Navigation()
            }
        }
    }
}