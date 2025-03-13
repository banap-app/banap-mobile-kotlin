package com.banap.banap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.banap.banap.view.Home
import com.banap.banap.ui.theme.BanapTheme
import com.banap.banap.view.Login
import com.banap.banap.view.NewEngineerFirstPage
import com.banap.banap.view.NewEngineerSecondPage
import com.banap.banap.view.NewProducer
import com.banap.banap.view.NewProperty
import com.banap.banap.view.Tutorial

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            BanapTheme {
                val navigationController = rememberNavController()

                NavHost(navController = navigationController, startDestination = "Tutorial"){
                    composable (
                        route = "Home"
                    ) {
                        Home(navigationController)
                    }

                    composable (
                        route = "Login"
                    ) {
                        Login(navigationController)
                    }

                    composable (
                        route = "NewProperty"
                    ) {
                        NewProperty(navigationController)
                    }

                    composable (
                        route = "NewProducer"
                    ) {
                        NewProducer(navigationController)
                    }

                    composable (
                        route = "NewEngineerFirstPage"
                    ) {
                        NewEngineerFirstPage(navigationController)
                    }

                    composable (
                        route = "NewEngineerSecondPage"
                    ) {
                        NewEngineerSecondPage(navigationController)
                    }

                    composable (
                        route = "Tutorial"
                    ) {
                        Tutorial(navigationController)
                    }
                }
            }
        }
    }
}