package com.banap.banap.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

fun setColorInText(
    texto: String,
    textoASerDestacado: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    corEmDestaque: Color,
    ordemInversa: Boolean
): AnnotatedString {
    var formattedString: AnnotatedString? = null

    if (ordemInversa) {

        formattedString = buildAnnotatedString {
            append(textoASerDestacado)

            addStyle(
                SpanStyle(
                    fontWeight = fontWeight,
                    color = corEmDestaque
                ),
                start = 0,
                end = textoASerDestacado.length
            )

            append(texto)

            toAnnotatedString()
        }

    } else {

        formattedString = buildAnnotatedString {
            append(texto)

            pushStyle(
                SpanStyle(
                    fontWeight = fontWeight,
                    color = corEmDestaque,
                    fontSize = fontSize
                )
            )

            append(textoASerDestacado)

            toAnnotatedString()
        }

    }

    return formattedString
}