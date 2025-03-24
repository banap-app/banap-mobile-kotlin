package com.banap.banap.validation.email.model

sealed class EmailTextFieldFormEvent {
    data class EmailChanged(val email: String) : EmailTextFieldFormEvent()

    object Submit : EmailTextFieldFormEvent()
}
