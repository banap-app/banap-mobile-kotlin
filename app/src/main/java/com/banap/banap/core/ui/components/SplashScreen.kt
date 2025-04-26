package com.banap.banap.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.banap.banap.R
import com.banap.banap.core.ui.theme.CINZA_CLARO
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_CLARO

@Composable
fun SplashScreen(
    isFirstScreen: Boolean = true
) {
    val navBarPaddingBottom = WindowInsets
        .navigationBars
        .asPaddingValues()
        .calculateBottomPadding()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isFirstScreen) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_cima),
                contentDescription = "Vetor de linhas",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .scale(1.2F)
            )
        }

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

        if (isFirstScreen) {
            Column (
                modifier = Modifier
                    .padding(bottom = navBarPaddingBottom + 10.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "from",
                    style = Typography.bodySmall,
                    color = CINZA_CLARO
                )

                Text(
                    text = "GreenHouse",
                    style = Typography.bodySmall,
                    color = VERDE_CLARO
                )
            }
        }
    }
}