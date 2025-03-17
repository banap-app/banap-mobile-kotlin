package com.banap.banap.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.Typography

@Composable
fun TextBoxRegistration(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    label: String,
    placeholder: String,
    tipoTeclado: KeyboardType
) {
    Row (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
    ) {
        TextBox(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            keyboardType = tipoTeclado,
            icon = null,
            iconColor = PRETO,
            placeholder = placeholder,
            passwordTextBox = false,
            label = label,
            labelTextStyle = Typography.titleMedium,
            labelColor = PRETO,
            isError = isError
        )
    }
}