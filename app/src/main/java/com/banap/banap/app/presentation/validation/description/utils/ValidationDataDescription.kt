package com.banap.banap.app.presentation.validation.description.utils

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.banap.banap.app.presentation.validation.model.RegistrationFormState
import com.banap.banap.app.presentation.validation.description.viewmodel.DescriptionTextFieldViewModel

@Composable
fun validationDataDescription (
    context: Context,
    viewModelDescription: DescriptionTextFieldViewModel,
    stateDescription: RegistrationFormState
) : Boolean {
    var descriptionSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelDescription.validationEventDescription.collect { event ->
            when (event) {
                is DescriptionTextFieldViewModel.ValidationDescriptionTextField.Success -> {
                    descriptionSuccess = true
                }
            }
        }
    }

    if (stateDescription.descriptionError != null) {
        descriptionSuccess = false
    }

    return descriptionSuccess
}