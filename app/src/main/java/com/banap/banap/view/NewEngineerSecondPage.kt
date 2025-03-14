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
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewEngineerSecondPage (
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
                rota = "NewEngineerFirstPage"
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
                var fieldCreaValue = TextBoxRegistration(
                    label = "CREA",
                    placeholder = "12345678",
                    tipoTeclado = KeyboardType.Number
                )

                var fieldNewEngineer = mutableListOf(fieldCreaValue)

                ButtonRegistration(
                    navigationController,
                    fieldNewEngineer,
                    buttonValue = "Cadastrar",
                    rota = "Home",
                    backgroundColor = VERDE_CLARO
                )
            }
        }
    }
}