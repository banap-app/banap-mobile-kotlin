package com.banap.banap.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.ShapeCarousel
import com.banap.banap.ui.theme.VERDE_CLARO

@Composable
fun Carousel(

) {
    Column (
        modifier = Modifier
            .padding(horizontal = 30.dp)
    ) {
        Card (
            modifier = Modifier
                .shadow(elevation = 3.dp, shape = ShapeCarousel.medium)
                .clip(
                    shape = ShapeCarousel.medium
                )
                .height(156.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = BRANCO
            )
        ) {
        }

        Row (
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Card (
                modifier = Modifier
                    .clip(
                        shape = ShapeCarousel.small
                    )
                    .height(8.dp)
                    .width(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = VERDE_CLARO
                )
            ) {
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Card (
                modifier = Modifier
                    .clip(
                        shape = ShapeCarousel.large
                    )
                    .size(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CINZA_CLARO
                )
            ) {
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Card (
                modifier = Modifier
                    .clip(
                        shape = ShapeCarousel.large
                    )
                    .size(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CINZA_CLARO
                )
            ) {
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Card (
                modifier = Modifier
                    .clip(
                        shape = ShapeCarousel.large
                    )
                    .size(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CINZA_CLARO
                )
            ) {
            }
        }
    }
}
