package com.banap.banap.app.presentation.validation.crea.event

sealed class CreaTextFieldFormEvent {
    data class CreaChanged(val crea: String) : CreaTextFieldFormEvent()

    object Submit : CreaTextFieldFormEvent()
}