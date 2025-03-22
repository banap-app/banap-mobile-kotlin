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
import androidx.compose.ui.unit.dp
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewProducer(
    navigationController: NavController
) {
    val context = LocalContext.current

    val viewModelName = viewModel<NameTextFieldViewModel>()
    val stateName = viewModelName.state

    val viewModelEmail = viewModel<EmailTextFieldViewModel>()
    val stateEmail = viewModelEmail.state

    val viewModelPassword = viewModel<PasswordTextFieldViewModel>()
    val statePassword = viewModelPassword.state

    val validationDataName = validationDataName(
        context = context,
        viewModelName = viewModelName,
        stateName = stateName
    )

    val validationDataEmail = validationDataEmail(
        context = context,
        viewModelEmail = viewModelEmail,
        stateEmail = stateEmail
    )

    val validationDataPassword = validationDataPassword(
        context = context,
        viewModelPassword = viewModelPassword,
        statePassword = statePassword
    )

    val isValidationSuccessful = validationDataName && validationDataEmail && validationDataPassword

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

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column {
            RegistrationHeader(
                navigationController
            )

            TitleRegistration(
                texto = "Olá, ",
                textoASerDestacado = "Produtor!",
                corEmDestaque = VERDE_CLARO,
                subTexto = "Antes de tudo...",
                tamanhoTextoDestacado = 28.sp,
                paginaUsuario = true,
                subtituloDestacado = "Um cadastro deve ser realizado!",
                subtitulo = "Precisamos das suas informações, nos diga seu..."
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column (
                    verticalArrangement = Arrangement.spacedBy(40.dp)
                ) {
                    TextBoxRegistration(
                        value = stateName.name,
                        onValueChange = {
                            viewModelName.onEvent(NameTextFieldFormEvent.NameChanged(it))
                            viewModelName.onEvent(NameTextFieldFormEvent.Submit)
                        },
                        isError = stateName.nameError != null,
                        errorState = stateName.nameError,
                        label = "Nome",
                        placeholder = "Exemplo",
                        tipoTeclado = KeyboardType.Text,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    TextBoxRegistration(
                        value = stateEmail.email,
                        onValueChange = {
                            viewModelEmail.onEvent(EmailTextFieldFormEvent.EmailChanged(it))
                            viewModelEmail.onEvent(EmailTextFieldFormEvent.Submit)
                        },
                        isError = stateEmail.emailError != null,
                        errorState = stateEmail.emailError,
                        label = "Email",
                        placeholder = "exemplo@gmail.com",
                        tipoTeclado = KeyboardType.Email,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    TextBoxRegistration(
                        value = statePassword.password,
                        onValueChange = {
                            viewModelPassword.onEvent(PasswordTextFieldFormEvent.PasswordChanged(it))
                            viewModelPassword.onEvent(PasswordTextFieldFormEvent.Submit)
                        },
                        isError = statePassword.passwordError != null,
                        errorState = statePassword.passwordError,
                        isPassword = true,
                        label = "Senha",
                        placeholder = "12345678",
                        tipoTeclado = KeyboardType.Password,
                        modifier = Modifier
                            .fillMaxWidth(),
                        lastOne = true
                    )
                }

                ButtonRegistration(
                    onClick = {
                        viewModelName.onEvent(NameTextFieldFormEvent.Submit)
                        viewModelEmail.onEvent(EmailTextFieldFormEvent.Submit)
                        viewModelPassword.onEvent(PasswordTextFieldFormEvent.Submit)

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
