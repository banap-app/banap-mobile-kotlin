package com.banap.banap.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.Typography

@Composable
fun TextBoxRegistration(
    label: String,
    placeholder: String
) : String {
    var fieldBoxProperty by remember {
        mutableStateOf("")
    }

    Row (
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
    ) {
        TextBox(
            value = fieldBoxProperty,
            onValueChange = {
                fieldBoxProperty = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            keyboardType = KeyboardType.Text,
            icon = null,
            iconColor = PRETO,
            placeholder = placeholder,
            passwordTextBox = false,
            label = label,
            labelTextStyle = Typography.titleMedium,
            labelColor = PRETO
        )
    }

    return fieldBoxProperty
}