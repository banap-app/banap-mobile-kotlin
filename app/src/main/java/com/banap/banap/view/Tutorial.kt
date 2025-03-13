package com.banap.banap.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO
import kotlinx.coroutines.launch

@Composable
fun Tutorial(
    navigationController: NavController
) {
    var texto by remember {
        mutableStateOf("")
    }

    var imagem by remember {
        mutableIntStateOf(0)
    }

    var numeroPagina by remember {
        mutableIntStateOf(0)
    }

    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        pageCount = {
            4
        }
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(bottom = 50.dp, top = innerPadding.calculateTopPadding() + 15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    pagerState.currentPage + 1
                                )
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VERDE_CLARO,
                            contentColor = BRANCO
                        ),
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp
                        )
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Flecha para a direita",
                            modifier = Modifier
                                .scale(1.2F)
                        )
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    pagerState.currentPage - 1
                                )
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VERDE_CLARO,
                            contentColor = BRANCO
                        ),
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp
                        ),
                        enabled = if (pagerState.currentPage >= 1) true else false
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Flecha para a esquerda",
                            modifier = Modifier
                                .scale(1.2F)
                        )
                    }
                }

                Button(
                    onClick = {
                        if (pagerState.currentPage == 3) {
                            navigationController.navigate("Login")
                        } else {
                            scope.launch {
                                pagerState.animateScrollToPage(4)
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BRANCO,
                        contentColor = VERDE_CLARO
                    ),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(
                        0.5.dp,
                        VERDE_CLARO.copy(
                            alpha = 0.2F
                        )
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp
                    )
                ) {
                    Text(
                        text = if (pagerState.currentPage == 3) "Sair" else "Pular",
                        style = Typography.bodyMedium,
                        fontSize = 14.sp
                    )
                }
            }

            Column {
                HorizontalPager(
                    state = pagerState
                ) { page ->
                    numeroPagina = page

                    when (page) {
                        0 -> {
                            imagem = R.drawable.tutorial_01
                            texto = "Forneça manualmente os nutrientes do solo da cultura"
                        }

                        1 -> {
                            imagem = R.drawable.tutorial_01
                            texto = "Ou utilize nosso produto para detectá-los automaticamente"
                        }

                        2 -> {
                            imagem = R.drawable.tutorial_03
                            texto = "O sistema fará uma análise desses dados fornecidos"
                        }

                        3 -> {
                            imagem = R.drawable.tutorial_04
                            texto = "E recomendará métodos de cultivo e manejo da cultura"
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 30.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(
                                id = imagem
                            ),
                            contentDescription = "Imagem de uma pessoa mexendo no celular",
                            modifier = Modifier
                                .scale(1.2F)
                        )

                        Spacer(modifier = Modifier.height(60.dp))

                        Text(
                            text = texto,
                            textAlign = TextAlign.Center,
                            style = Typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = VERDE_ESCURO
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 30.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(pagerState.pageCount + 1) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) VERDE_ESCURO else CINZA_CLARO

                        Card(
                            modifier = Modifier
                                .size(20.dp),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(
                                containerColor = color
                            )
                        ) {

                        }
                    }
                }
            }
        }
    }
}