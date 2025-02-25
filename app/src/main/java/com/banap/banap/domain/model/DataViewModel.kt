package com.banap.banap.domain.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banap.banap.network.ServiceProvider
import kotlinx.coroutines.launch
import java.io.IOException

class DataViewModel: ViewModel() {
    sealed interface DataUiState {
        data class Success(val photos: String) : DataUiState
        object Error : DataUiState
        object Loading : DataUiState
    }

    var dataUiState: DataUiState by mutableStateOf(DataUiState.Loading)
        private set

    init {
        getUserdata()
    }

    private fun getUserdata() {
        viewModelScope.launch {
            try {
                val response = ServiceProvider.retrofitService.getData()
                dataUiState = DataUiState.Success(
                    "${response.size}"
                )
            } catch (e: IOException) {
                dataUiState = DataUiState.Error
            }
        }
    }
}