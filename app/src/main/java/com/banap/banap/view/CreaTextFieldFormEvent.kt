package com.banap.banap.view

sealed class CreaTextFieldFormEvent {
    data class CreaChanged(val crea: String) : CreaTextFieldFormEvent()

    object Submit : CreaTextFieldFormEvent()
}