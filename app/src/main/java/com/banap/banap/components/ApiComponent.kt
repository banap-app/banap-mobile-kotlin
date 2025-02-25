package com.banap.banap.components

import androidx.compose.runtime.Composable
import com.banap.banap.domain.model.DataViewModel

@Composable
fun ApiComponent (
    dataUiState: DataViewModel.DataUiState
): String {
    when (dataUiState) {
        is DataViewModel.DataUiState.Loading -> return "Loading"
        is DataViewModel.DataUiState.Success -> return dataUiState.photos
        is DataViewModel.DataUiState.Error -> return "Erro"
    }
}