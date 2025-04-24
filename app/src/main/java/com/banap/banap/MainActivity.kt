package com.banap.banap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.banap.banap.home.presentation.Home
import com.banap.banap.ui.theme.BanapTheme
import com.banap.banap.login.presentation.Login
import com.banap.banap.engineer.registration.presentation.NewEngineerFirstPage
import com.banap.banap.engineer.registration.presentation.NewEngineerSecondPage
import com.banap.banap.field.registration.presentation.NewFieldFirstPage
import com.banap.banap.field.registration.presentation.NewFieldSecondPage
import com.banap.banap.field.registration.presentation.NewFieldThirdPage
import com.banap.banap.login.viewmodel.TokenViewModel
import com.banap.banap.producer.registration.presentation.NewProducer
import com.banap.banap.property.registration.presentation.NewProperty
import com.banap.banap.presentation.ReadyToStart
import com.banap.banap.presentation.Tutorial
import com.banap.banap.presentation.UserChoice
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            BanapTheme {
                val navigationController = rememberNavController()
                val tokenViewModel: TokenViewModel = hiltViewModel()

                NavHost(navController = navigationController, startDestination = "Tutorial"){
                    composable (
                        route = "Home"
                    ) {
                        Home(
                            navigationController,
                            tokenViewModel = tokenViewModel
                        )
                    }

                    composable (
                        route = "Login"
                    ) {
                        Login(
                            navigationController,
                            tokenViewModel = tokenViewModel
                        )
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

                    composable (
                        route = "ReadyToStart"
                    ) {
                        ReadyToStart(navigationController)
                    }

                    composable (
                        route = "UserChoice"
                    ) {
                        UserChoice(navigationController)
                    }

                    composable (
                        route = "NewFieldFirstPage"
                    ) {
                        NewFieldFirstPage(navigationController)
                    }

                    composable (
                        route = "NewFieldSecondPage"
                    ) {
                        NewFieldSecondPage(navigationController)
                    }

                    composable (
                        route = "NewFieldThirdPage"
                    ) {
                        NewFieldThirdPage(navigationController)
                    }
                }
            }
        }
    }
}