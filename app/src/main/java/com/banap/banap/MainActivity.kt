package com.banap.banap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.banap.banap.app.navigation.Navigation
import com.banap.banap.app.presentation.session.viewmodel.TokenViewModel
import com.banap.banap.core.network.SocketManager
import com.banap.banap.core.ui.theme.BanapTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var socketManager: SocketManager

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Banap)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val tokenViewModel: TokenViewModel = hiltViewModel()
            val uuid = "2448404d-9f2b-49bc-9f42-3d8f235a9458"

            println(uuid)

            socketManager = SocketManager(
                userID = uuid,
                token = tokenViewModel.getToken("token") ?: ""
            )

            BanapTheme {
                Navigation()
            }
        }
    }
}