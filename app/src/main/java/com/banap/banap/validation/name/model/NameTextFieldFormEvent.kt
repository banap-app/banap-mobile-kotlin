package com.banap.banap.validation.name.model

sealed class NameTextFieldFormEvent {
    data class NameChanged(val name: String) : NameTextFieldFormEvent()

    object Submit : NameTextFieldFormEvent()
}

