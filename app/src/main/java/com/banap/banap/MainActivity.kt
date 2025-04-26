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
import com.banap.banap.app.presentation.home.ui.screen.Home
import com.banap.banap.core.ui.theme.BanapTheme
import com.banap.banap.app.presentation.login.ui.screen.Login
import com.banap.banap.app.presentation.engineer.ui.registration.NewEngineerFirstPage
import com.banap.banap.app.presentation.engineer.ui.registration.NewEngineerSecondPage
import com.banap.banap.app.presentation.field.ui.registration.screen.NewFieldFirstPage
import com.banap.banap.app.presentation.field.ui.registration.screen.NewFieldSecondPage
import com.banap.banap.app.presentation.field.ui.registration.screen.NewFieldThirdPage
import com.banap.banap.app.presentation.session.viewmodel.TokenViewModel
import com.banap.banap.app.presentation.producer.ui.registration.NewProducer
import com.banap.banap.app.presentation.property.ui.registration.NewProperty
import com.banap.banap.app.presentation.readytostart.ui.ReadyToStart
import com.banap.banap.app.presentation.tutorial.ui.Tutorial
import com.banap.banap.app.presentation.userchoice.ui.UserChoice
import com.banap.banap.domain.viewmodel.TokenVerificationViewModel
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
                val tokenVerificationViewModel: TokenVerificationViewModel = hiltViewModel()

                NavHost(navController = navigationController, startDestination = "Tutorial"){
                    composable (
                        route = "Home"
                    ) {
                        Home(
                            navigationController,
                            tokenViewModel = tokenViewModel,
                            tokenVerificationViewModel = tokenVerificationViewModel
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