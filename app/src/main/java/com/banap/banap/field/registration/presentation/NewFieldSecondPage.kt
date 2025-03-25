package com.banap.banap.field.registration.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.banap.banap.field.registration.presentation.components.MapDescription
import com.banap.banap.field.registration.presentation.components.MapView
import com.banap.banap.ui.components.ButtonRegistration
import com.banap.banap.ui.components.RegistrationHeader
import com.banap.banap.ui.components.TitleRegistration
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.CINZA_ESCURO
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewFieldSecondPage (
    navigationController: NavController
) {
    var isValidationSuccessful by remember {
        mutableStateOf(true)
    }

    var backgroundColorButton by remember {
        mutableStateOf(CINZA_CLARO)
    }

    var contentColorButton by remember {
        mutableStateOf(CINZA_ESCURO)
    }

    val backgroundColor by animateColorAsState(
        targetValue = backgroundColorButton,
        label = "Button Background color",
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )

    val contentColor by animateColorAsState(
        targetValue = contentColorButton,
        label = "Button Content Color",
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )

    backgroundColorButton = when {
        isValidationSuccessful -> {
            VERDE_CLARO
        }

        else -> {
            CINZA_CLARO
        }
    }

    contentColorButton = when {
        isValidationSuccessful -> {
            BRANCO
        }

        else -> {
            CINZA_ESCURO
        }
    }

    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column {
            RegistrationHeader(
                navigationController
            )

            TitleRegistration(
                texto = "Cadastrando seu ",
                textoASerDestacado = "Talhão...",
                corEmDestaque = VERDE_ESCURO,
                subTexto = "",
                tamanhoTextoDestacado = 36.sp,
                paginaUsuario = false,
                subtituloDestacado = "",
                subtitulo = "Você deve clicar em pelo menos 3 pontos do mapa para que uma área seja delimitada, demonstrando assim, a localização do talhão."
            )

            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                MapView()

                ButtonRegistration(
                    onClick = {
                        if (isValidationSuccessful) {
                            navigationController.navigate("NewFieldThirdPage")
                        }
                    },
                    buttonValue = "Continuar",
                    backgroundColor = backgroundColor,
                    contentColor = contentColor
                )
            }
        }
    }
}