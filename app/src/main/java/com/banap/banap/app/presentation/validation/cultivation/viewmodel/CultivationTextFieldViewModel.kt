package com.banap.banap.app.presentation.validation.cultivation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banap.banap.app.presentation.validation.cultivation.event.CultivationTextFieldFormEvent
import com.banap.banap.app.presentation.validation.model.RegistrationFormState
import com.banap.banap.domain.use_case.validation.ValidateCultivation
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CultivationTextFieldViewModel (
    private val validateCultivation: ValidateCultivation = ValidateCultivation()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationCultivationTextField>()
    val validationEventCultivation = validationEventChannel.receiveAsFlow()

    fun onEvent (event: CultivationTextFieldFormEvent) {
        when (event) {
            is CultivationTextFieldFormEvent.CultivationChanged -> {
                state = state.copy(
                    cultivation = event.cultivation
                )
            }

            is CultivationTextFieldFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val cultivationResult = validateCultivation.execute(state.cultivation)

        if (!cultivationResult.successful) {
            state = state.copy(
                cultivationError = cultivationResult.errorMessage
            )
            return
        }

        state = state.copy(
            cultivationError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationCultivationTextField.Success)
        }
    }

    sealed class ValidationCultivationTextField {
        object Success : ValidationCultivationTextField()
    }
}