package com.banap.banap.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.LinkInteractionListener
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.TextUnit
import androidx.navigation.NavController

@Composable
fun setColorInText(
    texto: String,
    textoASerDestacado: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    corEmDestaque: Color,
    ordemInversa: Boolean,
    useLink: Boolean = false,
    navigationController: NavController? = null
): AnnotatedString {
    var formattedString: AnnotatedString? = null
    val uriHandler = LocalUriHandler.current

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

            if (useLink) {
                withLink(
                    LinkAnnotation.Clickable(
                        tag = "",
                        linkInteractionListener = {
                            navigationController?.navigate("UserChoice")
                        }
                    )
                ) {
                    append(textoASerDestacado)
                }
            } else {
                append(textoASerDestacado)
            }

            toAnnotatedString()
        }

    }

    return formattedString
}