package com.banap.banap.view

sealed class PasswordTextFieldFormEvent {
    data class PasswordChanged(val password: String) : PasswordTextFieldFormEvent()

    object Submit : PasswordTextFieldFormEvent()
}