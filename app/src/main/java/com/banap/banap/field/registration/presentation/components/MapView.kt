package com.banap.banap.field.registration.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MapView () {
    Card (
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
            .height(350.dp)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    ) {

    }
}