package com.banap.banap.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.banap.banap.login.presentation.components.TextBox
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERMELHO

@Composable
fun TextBoxRegistration(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    errorState: String?,
    isPassword: Boolean = false,
    label: String,
    placeholder: String,
    tipoTeclado: KeyboardType,
    modifier: Modifier,
    lastOne: Boolean = false
) {
    Row (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
    ) {
        Column {
            TextBox(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier,
                maxLines = 1,
                keyboardType = tipoTeclado,
                icon = null,
                iconColor = PRETO,
                placeholder = placeholder,
                passwordTextBox = isPassword,
                label = label,
                labelTextStyle = Typography.titleMedium,
                labelColor = PRETO,
                isError = isError,
                lastOne = lastOne
            )

            if (errorState != null) {
                Text(
                    text = errorState,
                    color = VERMELHO,
                    style = Typography.displaySmall
                )
            }
        }
    }
}