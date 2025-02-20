package com.banap.banap.view

import android.annotation.SuppressLint
import android.view.WindowMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.R
import com.banap.banap.components.Button
import com.banap.banap.components.TextBox
import com.banap.banap.model.setColorInText
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.ShapeLogin
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_ESCURO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Login(
    navigationController: NavController
) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        var fieldEmail by remember {
            mutableStateOf("")
        }

        var fieldSenha by remember {
            mutableStateOf("")
        }

        val screenWidth = LocalConfiguration.current.screenWidthDp.dp
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_cima),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .absoluteOffset(
                    x = screenWidth - 150.dp,
                    y = 0.dp
                ).scale(1.2F)
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.circulos_cima),
            contentDescription = "Desenhos de esferas verdes",
            modifier = Modifier
                .absoluteOffset(
                    x = screenWidth - 130.dp,
                    y = 230.dp
                ).scale(0.9F)
        )

        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.banap),
                contentDescription = "Logo do Banap",
                modifier = Modifier
                    .scale(0.9F)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Entre com sua\n conta!",
                textAlign = TextAlign.Center,
                style = Typography.titleSmall,
                color = VERDE_ESCURO
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextBox(
                value = fieldEmail,
                onValueChange = {
                    fieldEmail = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp),
                label = "Email",
                maxLines = 1,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextBox(
                value = fieldSenha,
                onValueChange = {
                    fieldSenha = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp),
                label = "Senha",
                maxLines = 1,
                keyboardType = KeyboardType.Password
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Esqueceu sua senha?",
                    textAlign = TextAlign.Center,
                    style = Typography.bodySmall,
                    fontWeight = FontWeight.Medium,
                    color = VERDE_ESCURO,
                    modifier = Modifier
                        .padding(end = 70.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            
            Button(
                texto = "Entrar",
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 98.dp),
                icon = false,
                shape = ShapeLogin.small
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = setColorInText(
                    texto = "Não possui uma conta? ",
                    textoASerDestacado = "Crie uma.",
                    fontWeight = FontWeight.Medium,
                    corEmDestaque = VERDE_ESCURO,
                    ordemInversa = false
                ),
                textAlign = TextAlign.Center,
                style = Typography.bodySmall,
                fontWeight = FontWeight.Medium
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.circulos_baixo),
            contentDescription = "Desenhos de esferas verdes",
            modifier = Modifier
                .absoluteOffset(
                    x = 50.dp,
                    y = screenHeight - 200.dp
                ).scale(0.9F)
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.desenho_de_baixo),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .absoluteOffset(
                    x = 0.dp,
                    y = screenHeight - 150.dp
                ).scale(1.2F)
        )
    }
}