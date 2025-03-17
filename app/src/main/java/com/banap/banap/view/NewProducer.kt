package com.banap.banap.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERMELHO

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
                Column {
                    TextBoxRegistration(
                        value = state.name,
                        onValueChange = {
                            viewModel.onEvent(RegistrationFormEvent.NameChanged(it))
                        },
                        isError = state.nameError != null,
                        label = "Nome",
                        placeholder = "Exemplo",
                        tipoTeclado = KeyboardType.Text
                    )

                    if (state.nameError != null) {
                        Text(
                            text = state.nameError,
                            color = VERMELHO,
                            style = Typography.displaySmall,
                            modifier = Modifier
                                .padding(horizontal = 30.dp)
                                .fillMaxWidth()
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    TextBoxRegistration(
                        value = state.email,
                        onValueChange = {
                            viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
                        },
                        isError = state.emailError != null,
                        label = "Email",
                        placeholder = "exemplo@gmail.com",
                        tipoTeclado = KeyboardType.Email
                    )

                    if (state.emailError != null) {
                        Text(
                            text = state.emailError,
                            color = VERMELHO,
                            style = Typography.displaySmall,
                            modifier = Modifier
                                .padding(horizontal = 30.dp)
                                .fillMaxWidth()
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    TextBoxRegistration(
                        value = state.password,
                        onValueChange = {
                            viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
                        },
                        isError = state.passwordError != null,
                        label = "Senha",
                        placeholder = "12345678",
                        tipoTeclado = KeyboardType.Password
                    )

                    if (state.passwordError != null) {
                        Text(
                            text = state.passwordError,
                            color = VERMELHO,
                            style = Typography.displaySmall,
                            modifier = Modifier
                                .padding(horizontal = 30.dp)
                                .fillMaxWidth()
                        )
                    }
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