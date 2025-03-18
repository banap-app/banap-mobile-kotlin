package com.banap.banap.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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

    val isSuccess = ValidationData(
        context,
        viewModelName,
        viewModelEmail,
        viewModelPassword,
        stateName,
        stateEmail,
        statePassword
    )

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

                        if (isSuccess) {
                            navigationController.navigate("Home")
                        }
                    },
                    buttonValue = "Cadastrar",
                    isSuccess = isSuccess,
                    backgroundColor = VERDE_CLARO
                )
            }
        }
    }
}

@Composable
fun ValidationData (
    context: Context,
    viewModelName: NameTextFieldViewModel,
    viewModelEmail: EmailTextFieldViewModel,
    viewModelPassword: PasswordTextFieldViewModel,
    stateName: RegistrationFormState,
    stateEmail: RegistrationFormState,
    statePassword: RegistrationFormState
) : Boolean {
    var nameSuccess by remember {
        mutableStateOf(false)
    }

    var emailSuccess by remember {
        mutableStateOf(false)
    }

    var passwordSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelName.validatioEventName.collect { event ->
            when (event) {
                is NameTextFieldViewModel.ValidationEventNameTextField.Success -> {
                    nameSuccess = true
                }
            }
        }
    }

    LaunchedEffect(key1 = context) {
        viewModelEmail.validatioEventEmail.collect { event ->
            when (event) {
                is EmailTextFieldViewModel.ValidationEmailTextField.Success -> {
                    emailSuccess = true
                }
            }
        }
    }

    LaunchedEffect(key1 = context) {
        viewModelPassword.validatioEventPassword.collect { event ->
            when (event) {
                is PasswordTextFieldViewModel.ValidationPasswordTextField.Success -> {
                    passwordSuccess = true
                }
            }
        }
    }

    if (stateName.nameError != null) {
        nameSuccess = false
    }

    if (stateEmail.emailError != null) {
        emailSuccess = false
    }

    if (statePassword.passwordError != null) {
        passwordSuccess = false
    }

    println("name: $nameSuccess")
    println("email: $emailSuccess")
    println("password: $passwordSuccess")

    return nameSuccess && emailSuccess && passwordSuccess
}
