package com.banap.banap.app.presentation.field.ui.information.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.banap.banap.R
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_ESCURO

@Composable
fun FieldTitle(
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.field),
            contentDescription = "Icone de Talhão",
            tint = VERDE_ESCURO
        )

        Text(
            text = title,
            style = Typography.headlineLarge,
            color = VERDE_ESCURO
        )
    }
}