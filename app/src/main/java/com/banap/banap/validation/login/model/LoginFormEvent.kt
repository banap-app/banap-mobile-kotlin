package com.banap.banap.validation.login.model

sealed class LoginFormEvent {
    data class Email(val email: String) : LoginFormEvent()
    data class Password(val password: String) : LoginFormEvent()

    object Submit : LoginFormEvent()
}