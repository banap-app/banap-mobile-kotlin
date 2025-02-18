package com.banap.banap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.banap.banap.components.Home
import com.banap.banap.ui.theme.BanapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanapTheme {
                val navigationController = rememberNavController()

                NavHost(navController = navigationController, startDestination = "Home"){
                    composable (
                        route = "Home"
                    ) {
                        Home(navigationController)
                    }
                }
            }
        }
    }
}