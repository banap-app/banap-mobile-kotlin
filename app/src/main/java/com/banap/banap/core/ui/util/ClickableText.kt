package com.banap.banap.core.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.navigation.NavController

@Composable
fun clickableText(
    navigationController: NavController,
    route: String,
    text: String
) : AnnotatedString {
    return buildAnnotatedString {
        withLink(
            LinkAnnotation.Clickable(
                tag = "Texto clicavel",
                linkInteractionListener = {
                    navigationController.navigate(route = route)
                }
            )
        ) {
            append(text)
        }
    }
}