package com.banap.banap.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.R

@Composable
fun RegistrationHeader(
    navigationController: NavController
) {
    Box{
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.linhas_propriedade),
            contentDescription = "Vetor de linhas",
            modifier = Modifier
                .padding(
                    top = 17.dp
                )
                .fillMaxWidth()
                .scale(1.2F)
        )

        IconButton(
            onClick = {
                navigationController.popBackStack()
            },
            modifier = Modifier
                .padding(
                    top = 40.dp,
                    start = 20.dp,
                    bottom = 40.dp
                )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
                contentDescription = "Icone de voltar",
                modifier = Modifier
                    .scale(1.2F)
            )
        }
    }
}