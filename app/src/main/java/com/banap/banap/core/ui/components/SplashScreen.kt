package com.banap.banap.core.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.R
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.CINZA_CLARO
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_CLARO
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigationController: NavController
) {
    val scale = remember { Animatable(0.8f) }
    val scaleBanapLogo = remember { Animatable(0.7f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 600,
                easing = FastOutSlowInEasing
            )
        )

        scaleBanapLogo.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 600,
                easing = FastOutSlowInEasing
            )
        )

        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 600
            )
        )
        delay(3_000L)
        navigationController.navigate("Tutorial")
    }

//    val navBarPaddingBottom = WindowInsets
//        .navigationBars
//        .asPaddingValues()
//        .calculateBottomPadding()

    Box(
        modifier = Modifier
            .background(BRANCO)
            .fillMaxSize(),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_cima),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .scale(scale.value)
                .alpha(alpha.value)
        )

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
                    .scale(scaleBanapLogo.value)
                    .alpha(alpha.value)
            )

            CircularProgressIndicator(
                strokeWidth = 4.dp,
                modifier = Modifier
                    .scale(scale.value)
                    .alpha(alpha.value)
                    .size(48.dp),
                color = VERDE_CLARO
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_baixo),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .scale(scale.value)
                .alpha(alpha.value)
        )

//        Column (
//            modifier = Modifier
//                .padding(bottom = navBarPaddingBottom + 10.dp)
//                .align(Alignment.BottomCenter),
//            verticalArrangement = Arrangement.spacedBy(
//                space = 5.dp
//            ),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "from",
//                style = Typography.bodyLarge,
//                color = CINZA_CLARO,
//                modifier = Modifier
//                    .scale(scale.value)
//                    .alpha(alpha.value)
//            )
//
//            Text(
//                text = "GreenHouse",
//                style = Typography.bodyLarge,
//                color = VERDE_CLARO,
//                modifier = Modifier
//                    .scale(scale.value)
//                    .alpha(alpha.value)
//            )
//        }
    }
}