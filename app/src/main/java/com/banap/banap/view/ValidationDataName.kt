package com.banap.banap.view

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun validationDataName (
    context: Context,
    viewModelName: NameTextFieldViewModel,
    stateName: RegistrationFormState
) : Boolean {
    var nameSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelName.validatioEventName.collect { event ->
            when (event) {
                is NameTextFieldViewModel.ValidationEventNameTextField.Success -> {
                    nameSuccess = true
                }
            }
        }
    }

    if (stateName.nameError != null) {
        nameSuccess = false
    }

    return nameSuccess
}