package com.banap.banap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.banap.banap.R
import com.banap.banap.components.ButtonRegistration
import com.banap.banap.components.RegistrationHeader
import com.banap.banap.components.TitleRegistration
import com.banap.banap.model.setColorInTextUserChoice
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserChoice(
    navigationController: NavController
) {
    var userChoice by remember {
        mutableStateOf("")
    }

    var colorButton by remember {
        mutableStateOf(CINZA_CLARO)
    }

    var cardProducer by remember {
        mutableStateOf(false)
    }

    var cardEngineer by remember {
        mutableStateOf(false)
    }

    var cardsUserChoice = mutableListOf(userChoice)

    if (cardProducer && !cardEngineer) {
        colorButton = VERDE_CLARO
    } else if (cardEngineer && !cardProducer) {
        colorButton = VERDE_ESCURO
    } else {
        colorButton = CINZA_CLARO
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column {
            RegistrationHeader(
                navigationController,
                rota = "ReadyToStart"
            )

            TitleRegistration(
                texto = "Antes de começar a utilizar o ",
                textoASerDestacado = "Banap...",
                corEmDestaque = VERDE_ESCURO,
                subTexto = "",
                tamanhoTextoDestacado = 28.sp,
                paginaUsuario = false,
                subtituloDestacado = "",
                subtitulo = "Precisamos saber para qual finalidade nosso sistema será usado."
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = setColorInTextUserChoice(
                        primeiroTexto = "Você é um ",
                        primeiroTextoASerDestacado = "produtor",
                        corPrimeiroTexto = VERDE_CLARO,
                        segundoTexto = ",\n ou ",
                        segundoTextoASerDestacado = "engenheiro?",
                        corSegundoTexto = VERDE_ESCURO
                    ),
                    style = Typography.labelMedium,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 20.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.Bottom
            ) {
                Box (
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Card(
                        onClick = {
                            cardProducer = !cardProducer
                            cardEngineer = false
                            userChoice = if (cardProducer) "userChoice" else ""
                        },
                        modifier = Modifier
                            .size(135.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = VERDE_CLARO
                        ),
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {

                    }

                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.produtor),
                        contentDescription = "Imagem representativa de um produtor",
                        modifier = Modifier
                            .padding(
                                bottom = 70.dp,
                                start = 10.dp
                            )
                            .scale(1.2F)
                    )
                }

                Text(
                    text = "OU",
                    style = Typography.bodyLarge,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(bottom = 60.dp)
                )

                Box (
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Card(
                        onClick = {
                            cardEngineer = !cardEngineer
                            cardProducer = false
                            userChoice = if (cardEngineer) "userChoice" else ""
                        },
                        modifier = Modifier
                            .size(135.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = VERDE_ESCURO
                        ),
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {

                    }

                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.engenheiro),
                        contentDescription = "Imagem representativa de um engenheiro",
                        modifier = Modifier
                            .padding(
                                bottom = 70.dp,
                                end = 20.dp
                            )
                            .scale(1.2F)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1F))

            ButtonRegistration(
                navigationController,
                fieldValue = cardsUserChoice,
                buttonValue = "Continuar",
                backgroundColor = colorButton,
                rota = if (cardProducer) "NewProducer" else "NewEngineerFirstPage"
            )
        }
    }
}