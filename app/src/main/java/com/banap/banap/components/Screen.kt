package com.banap.banap.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.banap.banap.R
import com.banap.banap.ui.theme.BRANCO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen() {
    Scaffold (
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp),
        ) {
            Header(
                nome = "Gilmar"
            )

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.linhas),
                contentDescription = "Linhas que separam o conteúdo",
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 40.dp
                    )
            )

            Carousel()
        }
    }
}