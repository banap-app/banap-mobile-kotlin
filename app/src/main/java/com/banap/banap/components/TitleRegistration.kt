package com.banap.banap.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.banap.banap.model.setColorInText
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_ESCURO

@Composable
fun TitleRegistration (
    texto: String,
    textoASerDestacado: String,
    subtitulo: String
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = setColorInText(
                texto = texto,
                textoASerDestacado = textoASerDestacado,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                corEmDestaque = VERDE_ESCURO,
                ordemInversa = false
            ),
            style = Typography.titleLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = subtitulo,
            style = Typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(40.dp))
    }
}