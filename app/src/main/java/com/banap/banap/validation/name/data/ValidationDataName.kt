package com.banap.banap.validation.name.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.banap.banap.validation.name.model.NameTextFieldViewModel
import com.banap.banap.validation.RegistrationFormState

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