package com.banap.banap.app.presentation.field.ui.registration.screen

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.banap.banap.app.presentation.field.ui.registration.components.MapView
import com.banap.banap.core.ui.components.ButtonRegistration
import com.banap.banap.core.ui.components.RegistrationHeader
import com.banap.banap.core.ui.components.TitleRegistration
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.CINZA_CLARO
import com.banap.banap.core.ui.theme.CINZA_ESCURO
import com.banap.banap.core.ui.theme.VERDE_CLARO
import com.banap.banap.core.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewFieldSecondPage(
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

    var isExpanded = remember { mutableStateOf(false) }

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

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        if (!isExpanded.value) {
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

                MapView(
                    isExpanded = isExpanded.value,
                    onClick = {
                        isExpanded.value = true
                    },
                    mapModifier = Modifier
                        .height(350.dp)
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.weight(1f))

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
        } else {
            MapView(
                isExpanded = isExpanded.value,
                onClick = {
                    isExpanded.value = false
                },
                mapModifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}