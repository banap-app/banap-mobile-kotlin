package com.banap.banap.app.presentation.property.ui.listing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.banap.banap.R
import com.banap.banap.core.ui.theme.BRANCO
import com.banap.banap.core.ui.theme.Typography
import com.banap.banap.core.ui.theme.VERDE_CLARO

@Composable
fun PropertyCard(
    fieldName: String
) {
    Card (
        modifier = Modifier
            .height(
                max(
                    150.dp,
                    150.dp
                )
            )
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = VERDE_CLARO,
            contentColor = BRANCO
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Row (
            modifier = Modifier
                .padding(start = 30.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Talhão",
                    style = Typography.titleMedium,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = fieldName,
                    style = Typography.displayLarge
                )
            }

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.propertyimagefield),
                contentDescription = "Imagem do Talhao da Propriedade"
            )
        }
    }
}