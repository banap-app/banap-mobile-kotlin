package com.banap.banap.validation.crea.data

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.banap.banap.validation.crea.model.CreaTextFieldViewModel
import com.banap.banap.validation.RegistrationFormState

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