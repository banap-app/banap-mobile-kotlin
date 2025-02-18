package com.banap.banap.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.R
import com.banap.banap.ui.theme.BRANCO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    navigationController: NavController
) {
    Scaffold (
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(top = 10.dp, bottom = 60.dp),
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

            Spacer(modifier = Modifier.height(60.dp))

            Property(
                titulo = "Propriedade 01"
            )

            Spacer(modifier = Modifier.height(60.dp))

            RecentActivities(
                titulo = "Atividades recentes",
                textoAtividade = "Voce cadastrou uma propriedade."
            )

            Spacer(modifier = Modifier.height(60.dp))

            Tasks(
                titulo = "Lista de tarefas",
                subTitulo = "Seus afazeres da semana!"
            )
        }
    }
}