package com.banap.banap.home.presentation.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.ui.components.Button
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.ShapeProperty
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO

@Composable
fun Property(
    titulo: String,
    navigationController: NavController
) {
    Column (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = titulo,
                style = Typography.titleLarge,
                color = VERDE_ESCURO
            )

            Icon(
                Icons.Outlined.KeyboardArrowUp,
                contentDescription = "Flecha clicavel",
                modifier = Modifier
                    .rotate(90.0F)
                    .scale(scale = 1.2F),
                tint = VERDE_ESCURO
            )
        }

        Row (
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FieldCard(
                nomeTalhao = "Talhão 01"
            )

            Spacer(
                modifier = Modifier
                    .width(25.dp)
            )

            NewFieldCard()
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                texto = "Nova Propriedade",
                modifier = Modifier
                    .padding(vertical = 18.dp, horizontal = 15.dp),
                icon = true,
                shape = ShapeProperty.small,
                onClick = {
                    navigationController.navigate("NewProperty")
                },
                backgroundColor = VERDE_CLARO,
                contentColor = BRANCO,
                defaultElevetion = 3.dp
            )
        }
    }
}