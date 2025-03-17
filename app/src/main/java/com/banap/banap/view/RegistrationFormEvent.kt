package com.banap.banap.view

sealed class RegistrationFormEvent {
    data class NameChanged(val name: String) : RegistrationFormEvent()
    data class EmailChanged(val email: String) : RegistrationFormEvent()
    data class PasswordChanged(val password: String) : RegistrationFormEvent()

    object Submit: RegistrationFormEvent()
}