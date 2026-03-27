package com.example.safracafe.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.safracafe.data.entities.Lavoura
import com.example.safracafe.data.repository.LavouraRepository

class LavouraEntryViewModel(private val lavouraRepository: LavouraRepository) : ViewModel() {
    var lavouraUiState by mutableStateOf(LavouraUiState())
        private set

    fun updateUiState(lavouraDetails: LavouraDetails) {
        lavouraUiState =
            LavouraUiState(lavouraDetails = lavouraDetails, isEntryValid = validateInput(lavouraDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            lavouraRepository.insertLavoura(lavouraUiState.lavouraDetails.toItem())
        }
    }

    private fun validateInput(uiState: LavouraDetails = lavouraUiState.lavouraDetails): Boolean {
        return with(uiState) {
            name.isNotBlank()
        }
    }
}

data class LavouraUiState(
    val lavouraDetails: LavouraDetails = LavouraDetails(),
    val isEntryValid: Boolean = false
)

data class LavouraDetails(val id: Int = 0, val name: String = "")

fun LavouraDetails.toItem(): Lavoura = Lavoura(
    lavouraId = id,
    nomeLavoura = name,
)

fun Lavoura.toItemUiState(isEntryValid: Boolean =false): LavouraUiState = LavouraUiState(
    lavouraDetails = this.toLavouraDetails(),
    isEntryValid = isEntryValid
)

fun Lavoura.toLavouraDetails(): LavouraDetails = LavouraDetails(
    id = lavouraId,
    name = nomeLavoura
)
