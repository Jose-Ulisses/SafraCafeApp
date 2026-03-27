package com.example.safracafe.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safracafe.data.repository.LavouraRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class LavouraDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val lavouraRepository: LavouraRepository,
) : ViewModel() {

    private val lavouraId: Int = checkNotNull(savedStateHandle[LavouraDetailsDestination.lavouraIdArg])

    val uiState: StateFlow<LavouraDetailsUiState> =
        lavouraRepository.getLavoura(lavouraId)
            .filterNotNull()
            .map {
                LavouraDetailsUiState(lavouraDetails = it.toLavouraDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = LavouraDetailsUiState()
            )

    suspend fun deleteItem() {
        lavouraRepository.deleteLavoura(uiState.value.lavouraDetails.toItem())
    }

    companion object {private const val TIMEOUT_MILLIS = 5_000L}
}

data class LavouraDetailsUiState(
    val lavouraDetails: LavouraDetails = LavouraDetails()
)