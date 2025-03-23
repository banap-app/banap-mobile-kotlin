package com.banap.banap.validation.password.model

sealed class PasswordTextFieldFormEvent {
    data class PasswordChanged(val password: String) : PasswordTextFieldFormEvent()

    object Submit : PasswordTextFieldFormEvent()
}