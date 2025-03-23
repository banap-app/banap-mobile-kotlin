package com.banap.banap.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.banap.banap.model.setColorInText
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO

@Composable
fun Header(
    nome: String,
    navigationController: NavController
) {
    Row (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = setColorInText(
                texto = "Olá, ",
                textoASerDestacado = "$nome!",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                corEmDestaque = VERDE_CLARO,
                ordemInversa = false
            ),
            style = Typography.headlineSmall,
            color = PRETO
        )

        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Outlined.Notifications,
                contentDescription = "Icone de notificação",
                modifier = Modifier
                    .scale(1.2F)
                    .padding(end = 20.dp)
            )

            Menu(
                dropDownItems = listOf(
                    DropDownItem("Sair")
                ),
                onItemClick = {
                    navigationController.navigate("Login")
                }
            )
        }
    }
}