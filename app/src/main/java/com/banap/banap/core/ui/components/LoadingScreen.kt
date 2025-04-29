package com.banap.banap.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.banap.banap.R
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.VERDE_CLARO

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .background(BRANCO)
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.banap),
                contentDescription = "Logo do Banap",
                modifier = Modifier
                    .scale(0.9F)
            )

            CircularProgressIndicator(
                strokeWidth = 4.dp,
                modifier = Modifier.size(48.dp),
                color = VERDE_CLARO
            )
        }
    }
}