package com.banap.banap.view

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun validationDataPassword (
    context: Context,
    viewModelPassword: PasswordTextFieldViewModel,
    statePassword: RegistrationFormState
) : Boolean {
    var passwordSuccess by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = context) {
        viewModelPassword.validatioEventPassword.collect { event ->
            when (event) {
                is PasswordTextFieldViewModel.ValidationPasswordTextField.Success -> {
                    passwordSuccess = true
                }
            }
        }
    }

    if (statePassword.passwordError != null) {
        passwordSuccess = false
    }

    return passwordSuccess
}