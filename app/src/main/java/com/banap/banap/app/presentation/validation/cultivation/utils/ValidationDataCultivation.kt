package com.banap.banap.app.presentation.validation.cultivation.utils

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.banap.banap.app.presentation.validation.model.RegistrationFormState
import com.banap.banap.app.presentation.validation.cultivation.viewmodel.CultivationTextFieldViewModel

@Composable
fun validationDataCultivation (
    context: Context,
    viewModelCultivation: CultivationTextFieldViewModel,
    stateCultivation: RegistrationFormState
) : Boolean {
    var cultivationSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelCultivation.validationEventCultivation.collect { event ->
            when (event) {
                is CultivationTextFieldViewModel.ValidationCultivationTextField.Success -> {
                    cultivationSuccess = true
                }
            }
        }
    }

    if (stateCultivation.cultivationError != null) {
        cultivationSuccess = false
    }

    return cultivationSuccess
}