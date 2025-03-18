package com.banap.banap.view

sealed class NameTextFieldFormEvent {
    data class NameChanged(val name: String) : NameTextFieldFormEvent()

    object Submit : NameTextFieldFormEvent()
}

