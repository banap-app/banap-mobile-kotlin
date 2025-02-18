package com.banap.banap.components

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
import com.banap.banap.ui.theme.Typography

@Composable
fun Activities(
    textoAtividade: String
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
            text = textoAtividade,
            style = Typography.bodyLarge,
            fontWeight = FontWeight.Normal
        )
    }
}