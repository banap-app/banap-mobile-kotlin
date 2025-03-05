package com.banap.banap.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
                    top = 17.dp,
                    bottom = 10.dp
                )
                .scale(1.2F)
        )

        Icon(
            Icons.Outlined.KeyboardArrowUp,
            contentDescription = "Flecha clicavel",
            modifier = Modifier
                .padding(
                    vertical = 40.dp,
                    horizontal = 30.dp
                )
                .rotate(270.0F)
                .scale(scale = 1.2F)
        )
    }
}