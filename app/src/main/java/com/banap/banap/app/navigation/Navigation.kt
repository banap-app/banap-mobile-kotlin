package com.banap.banap.app.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.banap.banap.app.presentation.engineer.ui.registration.NewEngineerFirstPage
import com.banap.banap.app.presentation.engineer.ui.registration.NewEngineerSecondPage
import com.banap.banap.app.presentation.field.ui.registration.screen.NewFieldFirstPage
import com.banap.banap.app.presentation.field.ui.registration.screen.NewFieldSecondPage
import com.banap.banap.app.presentation.field.ui.registration.screen.NewFieldThirdPage
import com.banap.banap.app.presentation.home.ui.screen.Home
import com.banap.banap.app.presentation.login.ui.screen.Login
import com.banap.banap.app.presentation.producer.ui.registration.NewProducer
import com.banap.banap.app.presentation.property.ui.registration.NewProperty
import com.banap.banap.app.presentation.readytostart.ui.ReadyToStart
import com.banap.banap.app.presentation.session.viewmodel.TokenViewModel
import com.banap.banap.app.presentation.tutorial.ui.Tutorial
import com.banap.banap.app.presentation.userchoice.ui.UserChoice
import com.banap.banap.core.ui.components.SplashScreen
import com.banap.banap.domain.viewmodel.TokenVerificationViewModel

@Composable
fun Navigation() {
    val navigationController = rememberNavController()
    val tokenViewModel: TokenViewModel = hiltViewModel()
    val tokenVerificationViewModel: TokenVerificationViewModel = hiltViewModel()

    NavHost(
        navController = navigationController,
        startDestination = "SplashScreen"
    ){
        composable (
            route = "SplashScreen",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            SplashScreen(navigationController)
        }

        composable (
            route = "Home",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            Home(
                navigationController,
                tokenViewModel = tokenViewModel,
                tokenVerificationViewModel = tokenVerificationViewModel
            )
        }

        composable (
            route = "Login",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            Login(
                navigationController,
                tokenViewModel = tokenViewModel
            )
        }

        composable (
            route = "NewProperty",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewProperty(navigationController)
        }

        composable (
            route = "NewProducer",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewProducer(navigationController)
        }

        composable (
            route = "NewEngineerFirstPage",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewEngineerFirstPage(navigationController)
        }

        composable (
            route = "NewEngineerSecondPage",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewEngineerSecondPage(navigationController)
        }

        composable (
            route = "Tutorial",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            Tutorial(navigationController)
        }

        composable (
            route = "ReadyToStart",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            ReadyToStart(navigationController)
        }

        composable (
            route = "UserChoice",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            UserChoice(navigationController)
        }

        composable (
            route = "NewFieldFirstPage",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewFieldFirstPage(navigationController)
        }

        composable (
            route = "NewFieldSecondPage",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewFieldSecondPage(navigationController)
        }

        composable (
            route = "NewFieldThirdPage",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(1000)
                )
            }
        ) {
            NewFieldThirdPage(navigationController)
        }
    }
}