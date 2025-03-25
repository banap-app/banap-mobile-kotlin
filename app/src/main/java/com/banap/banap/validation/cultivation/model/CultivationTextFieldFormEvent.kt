package com.banap.banap.validation.cultivation.model

sealed class CultivationTextFieldFormEvent {
    data class CultivationChanged(val cultivation: String) : CultivationTextFieldFormEvent()

    object Submit : CultivationTextFieldFormEvent()
}