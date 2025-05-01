package com.banap.banap.app.presentation.field.ui.information.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.banap.banap.R
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_CLARO
import com.banap.banap.core.ui.theme.VERDE_ESCURO

@Composable
fun FieldImage(
    cultivation: String,
    numberCultivation: String,
    image: Int
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .height(320.dp)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(
                    shape = RoundedCornerShape(10.dp)
                )
                .fillMaxWidth()
                .height(65.dp),
            colors = CardDefaults.cardColors(
                containerColor = BRANCO
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 13.dp,
                        top = 28.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 10.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fieldiconplant),
                        contentDescription = "Icone de Talhão",
                        tint = VERDE_ESCURO
                    )

                    Text(
                        text = cultivation,
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = VERDE_CLARO
                    )
                }

                Text(
                    text = numberCultivation,
                    style = Typography.bodyLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = VERDE_CLARO
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Foto do talhao",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}