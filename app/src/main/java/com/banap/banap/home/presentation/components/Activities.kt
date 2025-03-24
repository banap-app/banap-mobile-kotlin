package com.banap.banap.home.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banap.banap.model.setColorInText
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO

@Composable
fun Activities(
    atividadeRealizada: String,
    autorAtividade: String
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Outlined.Person,
            contentDescription = "Icone de pessoa"
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = setColorInText(
                texto = atividadeRealizada,
                textoASerDestacado = autorAtividade,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                corEmDestaque = VERDE_CLARO,
                ordemInversa = true
            ),
            style = Typography.bodyLarge,
            fontWeight = FontWeight.Normal
        )
    }
}