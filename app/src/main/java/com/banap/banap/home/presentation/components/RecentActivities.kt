package com.banap.banap.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.banap.banap.ui.theme.CINZA_ESCURO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_ESCURO

@Composable
fun RecentActivities(
    titulo: String,
    atividadeRealizada: String,
    autorAtividade: String
) {
    Column (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = titulo,
            style = Typography.titleLarge,
            color = VERDE_ESCURO
        )

        Spacer(modifier = Modifier.height(20.dp))

        Activities(
            atividadeRealizada,
            autorAtividade
        )

        Spacer(modifier = Modifier.height(10.dp))

        Activities(
            atividadeRealizada,
            autorAtividade
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "10 de Maio 2025 ás 17:54",
            style = Typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = CINZA_ESCURO
        )
    }
}