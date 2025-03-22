package com.banap.banap.view

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun validationData (
    context: Context,
    viewModelName: NameTextFieldViewModel,
    viewModelEmail: EmailTextFieldViewModel,
    viewModelPassword: PasswordTextFieldViewModel,
    stateName: RegistrationFormState,
    stateEmail: RegistrationFormState,
    statePassword: RegistrationFormState
) : Boolean {
    var nameSuccess by remember {
        mutableStateOf(false)
    }

    var emailSuccess by remember {
        mutableStateOf(false)
    }

    var passwordSuccess by remember {
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

    LaunchedEffect(key1 = context) {
        viewModelEmail.validationEventEmail.collect { event ->
            when (event) {
                is EmailTextFieldViewModel.ValidationEmailTextField.Success -> {
                    emailSuccess = true
                }
            }
        }
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

    if (stateName.nameError != null) {
        nameSuccess = false
    }

    if (stateEmail.emailError != null) {
        emailSuccess = false
    }

    if (statePassword.passwordError != null) {
        passwordSuccess = false
    }

    return nameSuccess && emailSuccess && passwordSuccess
}