package com.example.safracafe.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safracafe.data.entities.Lavoura
import com.example.safracafe.data.repository.LavouraRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LavouraEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val lavouraRepository: LavouraRepository) : ViewModel() {
    var lavouraUiState by mutableStateOf(LavouraUiState())
        private set

    private val lavouraId: Int = checkNotNull(savedStateHandle[LavouraEditDestination.lavouraIdArg])

    init {
        viewModelScope.launch {
            lavouraUiState = lavouraRepository.getLavoura(lavouraId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }

    suspend fun updateLavoura() {
        if (validateInput(lavouraUiState.lavouraDetails)) {
            lavouraRepository.updateLavoura(lavouraUiState.lavouraDetails.toItem())
        }
    }

    fun updateUiState(lavouraDetails: LavouraDetails) {
        lavouraUiState =
            LavouraUiState(lavouraDetails = lavouraDetails, isEntryValid = validateInput(lavouraDetails))
    }

    private fun validateInput(uiState: LavouraDetails = lavouraUiState.lavouraDetails): Boolean {
        return with(uiState) {
            name.isNotBlank()
        }
    }
}