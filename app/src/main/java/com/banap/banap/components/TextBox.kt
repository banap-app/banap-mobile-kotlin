package com.banap.banap.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.VERDE_CLARO

@Composable
fun TextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = VERDE_CLARO,
            focusedLabelColor = VERDE_CLARO,
            cursorColor = VERDE_CLARO,
            focusedContainerColor = BRANCO,
            unfocusedContainerColor = BRANCO,
            unfocusedTextColor = PRETO
        ),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}