package com.banap.banap.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.banap.banap.R
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.Typography

@Composable
fun Header(
    nome: String
) {
    Row (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Olá, $nome!",
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
                    .size(55.dp)
                    .padding(end = 20.dp)
            )

            Image(
                painter = painterResource(R.drawable.foto_de_perfil),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }
}