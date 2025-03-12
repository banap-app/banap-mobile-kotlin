package com.banap.banap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.banap.banap.components.ButtonRegistration
import com.banap.banap.components.RegistrationHeader
import com.banap.banap.components.TextBoxRegistration
import com.banap.banap.components.TitleRegistration
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewEngineerFirstPage (
    navigationController: NavController
) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column {
            RegistrationHeader(
                navigationController,
                rota = "Home"
            )

            TitleRegistration(
                texto = "Olá, ",
                textoASerDestacado = "Engenheiro!",
                corEmDestaque = VERDE_ESCURO,
                subTexto = "Antes de tudo...",
                tamanhoTextoDestacado = 28.sp,
                paginaUsuario = true,
                subtituloDestacado = "Um cadastro deve ser realizado!",
                subtitulo = "Precisamos das suas informações, nos diga seu..."
            )

            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                var fieldNameValue = TextBoxRegistration(
                    label = "Nome",
                    placeholder = "Exemplo",
                    tipoTeclado = KeyboardType.Text
                )

                var fieldEmailValue = TextBoxRegistration(
                    label = "Email",
                    placeholder = "exemplo@gmail.com",
                    tipoTeclado = KeyboardType.Email
                )

                var fieldPasswordValue = TextBoxRegistration(
                    label = "Senha",
                    placeholder = "12345678",
                    tipoTeclado = KeyboardType.Password
                )

                var fieldsNewEngineer = mutableListOf(fieldNameValue, fieldEmailValue, fieldPasswordValue)

                ButtonRegistration(
                    navigationController,
                    fieldsNewEngineer,
                    buttonValue = "Continuar",
                    rota = "NewEngineerSecondPage"
                )
            }
        }
    }
}