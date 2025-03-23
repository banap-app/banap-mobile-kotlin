package com.banap.banap.validation.crea.model

sealed class CreaTextFieldFormEvent {
    data class CreaChanged(val crea: String) : CreaTextFieldFormEvent()

    object Submit : CreaTextFieldFormEvent()
}