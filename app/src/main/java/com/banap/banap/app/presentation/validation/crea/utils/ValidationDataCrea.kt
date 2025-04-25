package com.banap.banap.app.presentation.validation.crea.utils

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.banap.banap.app.presentation.validation.crea.viewmodel.CreaTextFieldViewModel
import com.banap.banap.app.presentation.validation.model.RegistrationFormState

@Composable
fun validationDataCrea (
    context: Context,
    viewModelCrea: CreaTextFieldViewModel,
    stateCrea: RegistrationFormState
) : Boolean {
    var creaSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelCrea.validationEventCrea.collect { event ->
            when (event) {
                is CreaTextFieldViewModel.ValidationCreaTextField.Success -> {
                    creaSuccess = true
                }
            }
        }
    }

    if (stateCrea.emailError != null) {
        creaSuccess = false
    }

    return creaSuccess
}