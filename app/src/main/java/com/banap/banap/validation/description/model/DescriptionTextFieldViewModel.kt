package com.banap.banap.validation.description.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banap.banap.validation.RegistrationFormState
import com.banap.banap.validation.crea.model.CreaTextFieldViewModel.ValidationCreaTextField
import com.banap.banap.validation.description.model.use_case.ValidateDescription
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class DescriptionTextFieldViewModel (
    private val validateDescription: ValidateDescription = ValidateDescription()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationDescriptionTextField>()
    val validationEventDescription = validationEventChannel.receiveAsFlow()

    fun onEvent (event: DescriptionTextFieldFormEvent) {
        when (event) {
            is DescriptionTextFieldFormEvent.DescriptionChanged -> {
                state = state.copy(
                    description = event.description
                )
            }

            is DescriptionTextFieldFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val descriptionResult = validateDescription.execute(state.description)

        if (!descriptionResult.successful) {
            state = state.copy(
                descriptionError = descriptionResult.errorMessage
            )
            return
        }

        state = state.copy(
            descriptionError = null
        )

        viewModelScope.launch {
            validationEventChannel.send(ValidationDescriptionTextField.Success)
        }
    }

    sealed class ValidationDescriptionTextField {
        object Success : ValidationDescriptionTextField()
    }
}