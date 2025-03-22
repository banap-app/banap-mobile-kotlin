package com.banap.banap.view

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
import com.banap.banap.components.ButtonRegistration
import com.banap.banap.components.RegistrationHeader
import com.banap.banap.components.TextBoxRegistration
import com.banap.banap.components.TitleRegistration
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.CINZA_ESCURO
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewProperty(
    navigationController: NavController
) {
    val context = LocalContext.current

    val viewModelName = viewModel<NameTextFieldViewModel>()
    val stateName = viewModelName.state

    var isValidationSuccessful by remember {
        mutableStateOf(false)
    }

    isValidationSuccessful = validationDataName(
        context = context,
        viewModelName = viewModelName,
        stateName = stateName
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
        isValidationSuccessful && stateName.nameError == null -> {
            VERDE_CLARO
        }

        else -> {
            CINZA_CLARO
        }
    }

    contentColorButton = when {
        isValidationSuccessful && stateName.nameError == null -> {
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
                texto = "Cadastrando sua ",
                textoASerDestacado = "propriedade...",
                corEmDestaque = VERDE_ESCURO,
                subTexto = "",
                tamanhoTextoDestacado = 36.sp,
                paginaUsuario = false,
                subtituloDestacado = "",
                subtitulo = "O primeiro passo a ser feito é cadastrar sua propriedade..."
            )

            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextBoxRegistration(
                    value = stateName.name,
                    onValueChange = {
                        viewModelName.onEvent(NameTextFieldFormEvent.NameChanged(it))
                        viewModelName.onEvent(NameTextFieldFormEvent.Submit)
                    },
                    isError = stateName.nameError != null,
                    errorState = stateName.nameError,
                    label = "Nome da Propriedade",
                    placeholder = "Propriedade 01",
                    tipoTeclado = KeyboardType.Text,
                    modifier = Modifier
                        .fillMaxWidth(),
                    lastOne = true
                )

                ButtonRegistration(
                    onClick = {
                        viewModelName.onEvent(NameTextFieldFormEvent.Submit)

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