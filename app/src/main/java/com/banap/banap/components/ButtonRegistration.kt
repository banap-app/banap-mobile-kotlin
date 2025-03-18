package com.banap.banap.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.banap.banap.R
import com.banap.banap.ui.theme.CINZA_CLARO
import com.banap.banap.ui.theme.CINZA_ESCURO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.view.RegistrationFormEvent
import com.banap.banap.view.RegistrationFormState
import com.banap.banap.view.RegistrationViewModel

@Composable
fun ButtonRegistration(
    navigationController: NavController,
    viewModel: RegistrationViewModel,
    textFieldState: RegistrationFormState,
    buttonValue: String,
    backgroundColor: Color,
    rota: String
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is RegistrationViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "Registration successful",
                        Toast.LENGTH_LONG
                    ).show()

                    navigationController.navigate(rota)
                }
            }
        }
    }

    var containerColor: Color = CINZA_CLARO
    var contentColor: Color = CINZA_ESCURO

    Card(
        onClick = {
            viewModel.onEvent(RegistrationFormEvent.Submit)
        },
        modifier = Modifier
            .height(98.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = buttonValue,
                modifier = Modifier
                    .padding(vertical = 35.dp),
                style = Typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
                contentDescription = "Icone de voltar",
                modifier = Modifier
                    .scale(1.2F)
                    .rotate(180F)
            )
        }
    }
}