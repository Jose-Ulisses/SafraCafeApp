package com.example.safracafe.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LavouraViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Lavoura>>
    private val repository: LavouraRepository

    init{
        val lavouraDao = SafraDatabase.getDatabase(application).lavouraDao()
        repository = LavouraRepository(lavouraDao)
        readAllData = repository.readAllData
    }

    fun addLavoura(lavoura: Lavoura){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addLavoura(lavoura)
        }
    }
}