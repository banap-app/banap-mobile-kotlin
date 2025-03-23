package com.banap.banap.engineer.registration.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.banap.banap.ui.components.ButtonRegistration
import com.banap.banap.ui.components.RegistrationHeader
import com.banap.banap.ui.components.TextBoxRegistration
import com.banap.banap.ui.components.TitleRegistration
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.CINZA_ESCURO
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO
import com.banap.banap.validation.crea.data.validationDataCrea
import com.banap.banap.validation.crea.model.CreaTextFieldFormEvent
import com.banap.banap.validation.crea.model.CreaTextFieldViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewEngineerSecondPage (
    navigationController: NavController
) {
    val context = LocalContext.current

    val viewModelCrea = viewModel<CreaTextFieldViewModel>()
    val stateCrea = viewModelCrea.state

    var isValidationSuccessful by remember {
        mutableStateOf(false)
    }

    isValidationSuccessful = validationDataCrea(
        context = context,
        viewModelCrea = viewModelCrea,
        stateCrea = stateCrea
    )

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
        isValidationSuccessful && stateCrea.creaError == null -> {
            VERDE_CLARO
        }

        else -> {
            CINZA_CLARO
        }
    }

    contentColorButton = when {
        isValidationSuccessful && stateCrea.creaError == null -> {
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
                texto = "Precisamos dos \nseus ",
                textoASerDestacado = "documentos...",
                corEmDestaque = VERDE_ESCURO,
                subTexto = "",
                tamanhoTextoDestacado = 28.sp,
                paginaUsuario = false,
                subtituloDestacado = "Agora falta pouco!",
                subtitulo = "Só precisamos de uma confirmação de seus dados... "
            )

            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextBoxRegistration(
                    value = stateCrea.crea,
                    onValueChange = {
                        viewModelCrea.onEvent(CreaTextFieldFormEvent.CreaChanged(it))
                        viewModelCrea.onEvent(CreaTextFieldFormEvent.Submit)
                    },
                    isError = stateCrea.creaError != null,
                    errorState = stateCrea.creaError,
                    label = "CREA",
                    placeholder = "12345678",
                    tipoTeclado = KeyboardType.Number,
                    modifier = Modifier
                        .fillMaxWidth(),
                    lastOne = true
                )

                ButtonRegistration(
                    onClick = {
                        viewModelCrea.onEvent(CreaTextFieldFormEvent.Submit)

                        if (isValidationSuccessful) {
                            navigationController.navigate("Home")
                        }
                    },
                    buttonValue = "Cadastrar",
                    backgroundColor = backgroundColor,
                    contentColor = contentColor
                )
            }
        }
    }
}