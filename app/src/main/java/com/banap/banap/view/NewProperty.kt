package com.banap.banap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.banap.banap.components.RegistrationHeader
import com.banap.banap.ui.theme.BRANCO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewProperty(
    navigationController: NavController
) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column {
            RegistrationHeader(navigationController)
        }
    }
}