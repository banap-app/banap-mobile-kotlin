package com.banap.banap.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.banap.banap.ui.theme.AMARELO
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.ShapeCarousel
import com.banap.banap.ui.theme.Typography
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
            Row (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "27 °C",
                        style = Typography.headlineLarge,
                        color = VERDE_CLARO
                    )
                    Text(
                        text = "quinta-feira, 12:00",
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Normal,
                        color = VERDE_CLARO
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Sol",
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Light,
                        color = VERDE_CLARO
                    )
                }

                Spacer(modifier = Modifier.width(44.dp))

                Card (
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp)
                        .clip(
                            shape = ShapeCarousel.large
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = AMARELO
                    )
                ) {

                }
            }
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
