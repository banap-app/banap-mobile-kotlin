package com.banap.banap.app.presentation.validation.email.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.banap.banap.app.presentation.validation.email.viewmodel.EmailTextFieldViewModel
import com.banap.banap.app.presentation.validation.model.RegistrationFormState

@Composable
fun validationDataEmail (
    context: Context,
    viewModelEmail: EmailTextFieldViewModel,
    stateEmail: RegistrationFormState
) : Boolean {
    var emailSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelEmail.validationEventEmail.collect { event ->
            when (event) {
                is EmailTextFieldViewModel.ValidationEmailTextField.Success -> {
                    emailSuccess = true
                }
            }
        }
    }

    if (stateEmail.emailError != null) {
        emailSuccess = false
    }

    return emailSuccess
}