package com.banap.banap.app.presentation.validation.email.event

sealed class EmailTextFieldFormEvent {
    data class EmailChanged(val email: String) : EmailTextFieldFormEvent()

    object Submit : EmailTextFieldFormEvent()
}
