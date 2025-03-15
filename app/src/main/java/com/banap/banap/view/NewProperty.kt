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
fun NewProperty(
    navigationController: NavController
) {
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
                var fieldValue = TextBoxRegistration(
                    label = "Nome da Propriedade",
                    placeholder = "Propriedade 01",
                    tipoTeclado = KeyboardType.Text
                )

                var fieldsNewProducer = mutableListOf(fieldValue)

                ButtonRegistration(
                    navigationController,
                    fieldsNewProducer,
                    buttonValue = "Cadastrar",
                    rota = "Home",
                    backgroundColor = VERDE_CLARO
                )
            }
        }
    }
}