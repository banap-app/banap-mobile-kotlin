package com.banap.banap.validation.description.model

sealed class DescriptionTextFieldFormEvent {
    data class DescriptionChanged(val description: String) : DescriptionTextFieldFormEvent()

    object Submit : DescriptionTextFieldFormEvent()
}