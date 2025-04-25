package com.banap.banap.app.presentation.home.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.core.ui.components.Button
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.CINZA_ESCURO
import com.banap.banap.core.ui.theme.ShapeProperty
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_CLARO
import com.banap.banap.core.ui.theme.VERDE_ESCURO

@Composable
fun Tasks (
    titulo: String,
    subTitulo: String,
    navigationController: NavController
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

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = subTitulo,
            style = Typography.titleSmall,
            color = VERDE_ESCURO
        )

        Spacer(modifier = Modifier.height(60.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Ainda não há um\ntalhão cadastrado!",
                textAlign = TextAlign.Center,
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = CINZA_ESCURO
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                texto = "Novo Talhão",
                modifier = Modifier
                    .padding(vertical = 18.dp, horizontal = 15.dp),
                icon = true,
                shape = ShapeProperty.small,
                onClick = {
                    navigationController.navigate("NewFieldFirstPage")
                },
                backgroundColor = VERDE_CLARO,
                contentColor = BRANCO,
                defaultElevetion = 3.dp
            )
        }
    }
}