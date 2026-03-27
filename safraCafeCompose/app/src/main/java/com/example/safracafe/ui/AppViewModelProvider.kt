package com.example.safracafe.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.safracafe.SafraCafeApplication
import com.example.safracafe.ui.home.HomeViewModel
import com.example.safracafe.ui.item.LavouraDetailsViewModel
import com.example.safracafe.ui.item.LavouraEditViewModel
import com.example.safracafe.ui.item.LavouraEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for ItemEditViewModel
        initializer {
            LavouraEditViewModel(
                this.createSavedStateHandle(),
                SafraCafeApplication().container.lavouraRepository
            )
        }
        // Initializer for ItemEntryViewModel
        initializer {
            LavouraEntryViewModel(SafraCafeApplication().container.lavouraRepository)
        }

        // Initializer for ItemDetailsViewModel
        initializer {
            LavouraDetailsViewModel(
                this.createSavedStateHandle(),
                SafraCafeApplication().container.lavouraRepository
            )
        }

        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(SafraCafeApplication().container.lavouraRepository)
        }
    }
}

fun CreationExtras.SafraCafeApplication(): SafraCafeApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as SafraCafeApplication)