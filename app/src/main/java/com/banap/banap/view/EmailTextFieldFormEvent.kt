package com.banap.banap.view

sealed class EmailTextFieldFormEvent {
    data class EmailChanged(val email: String) : EmailTextFieldFormEvent()

    object Submit : EmailTextFieldFormEvent()
}
