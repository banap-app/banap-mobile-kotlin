package com.banap.banap.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.banap.banap.model.setColorInText
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_ESCURO

@Composable
fun TitleRegistration (
    texto: String,
    textoASerDestacado: String,
    corEmDestaque: Color,
    subTexto: String,
    tamanhoTextoDestacado: TextUnit,
    paginaUsuario: Boolean,
    subtituloDestacado: String,
    subtitulo: String
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        if (paginaUsuario) {
            Text(
                text = setColorInText(
                    texto = texto,
                    textoASerDestacado = textoASerDestacado,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = tamanhoTextoDestacado,
                    corEmDestaque = corEmDestaque,
                    ordemInversa = false
                ),
                style = Typography.titleLarge
            )

            Text(
                text = subTexto,
                style = Typography.titleLarge
            )
        } else {
            Text(
                text = setColorInText(
                    texto = texto,
                    textoASerDestacado = textoASerDestacado,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = tamanhoTextoDestacado,
                    corEmDestaque = VERDE_ESCURO,
                    ordemInversa = false
                ),
                style = Typography.titleLarge
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (paginaUsuario || subtituloDestacado.isNotEmpty()) {
            Text(
                text = subtituloDestacado,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = subtitulo,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify
            )
        } else {
            if (subtitulo.isNotEmpty()) {
                Text(
                    text = subtitulo,
                    style = Typography.bodyLarge,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Justify
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}