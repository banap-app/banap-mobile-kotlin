package com.banap.banap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    val viewModel = viewModel<RegistrationViewModel>()
    val state = viewModel.state

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
                        value = state.name,
                        onValueChange = {
                            viewModel.onEvent(RegistrationFormEvent.NameChanged(it))
                        },
                        isError = state.nameError != null,
                        errorState = state.nameError,
                        label = "Nome",
                        placeholder = "Exemplo",
                        tipoTeclado = KeyboardType.Text
                    )

                    TextBoxRegistration(
                        value = state.email,
                        onValueChange = {
                            viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
                        },
                        isError = state.emailError != null,
                        errorState = state.emailError,
                        label = "Email",
                        placeholder = "exemplo@gmail.com",
                        tipoTeclado = KeyboardType.Email
                    )

                    TextBoxRegistration(
                        value = state.password,
                        onValueChange = {
                            viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
                        },
                        isError = state.passwordError != null,
                        errorState = state.passwordError,
                        label = "Senha",
                        placeholder = "12345678",
                        tipoTeclado = KeyboardType.Password
                    )
                }

                ButtonRegistration(
                    navigationController,
                    viewModel,
                    textFieldState = state,
                    buttonValue = "Cadastrar",
                    rota = "Home",
                    backgroundColor = VERDE_CLARO
                )
            }
        }
    }
}