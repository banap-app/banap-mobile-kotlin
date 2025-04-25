package com.banap.banap.app.presentation.validation.description.event

sealed class DescriptionTextFieldFormEvent {
    data class DescriptionChanged(val description: String) : DescriptionTextFieldFormEvent()

    object Submit : DescriptionTextFieldFormEvent()
}