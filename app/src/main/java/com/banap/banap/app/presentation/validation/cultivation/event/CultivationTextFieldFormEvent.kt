package com.banap.banap.app.presentation.validation.cultivation.event

sealed class CultivationTextFieldFormEvent {
    data class CultivationChanged(val cultivation: String) : CultivationTextFieldFormEvent()

    object Submit : CultivationTextFieldFormEvent()
}