package com.banap.banap.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.banap.banap.home.presentation.components.Carousel
import com.banap.banap.home.presentation.components.Header
import com.banap.banap.home.presentation.components.Property
import com.banap.banap.home.presentation.components.RecentActivities
import com.banap.banap.home.presentation.components.Tasks
import com.banap.banap.ui.theme.BRANCO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    navigationController: NavController
) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        containerColor = BRANCO
    ) {
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(top = 40.dp, bottom = 60.dp),
        ) {
            Header(
                nome = "Gilmar",
                navigationController
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
                titulo = "Propriedade 01",
                navigationController = navigationController
            )

            Spacer(modifier = Modifier.height(60.dp))

            RecentActivities(
                titulo = "Atividades recentes",
                atividadeRealizada = "cadastrou uma propriedade.",
                autorAtividade = "Você "
            )

            Spacer(modifier = Modifier.height(60.dp))

            Tasks(
                titulo = "Lista de tarefas",
                subTitulo = "Seus afazeres da semana!",
                navigationController
            )
        }
    }
}