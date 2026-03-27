package com.example.safracafe.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safracafe.data.entities.Lavoura
import com.example.safracafe.data.repository.LavouraRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(lavouraRepository: LavouraRepository) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> =
        lavouraRepository.getAllLavouras().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val lavouraList: List<Lavoura> = listOf())