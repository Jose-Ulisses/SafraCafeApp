package com.example.safracafe.data

import androidx.lifecycle.LiveData

class LavouraRepository(private val lavouraDao: LavouraDao) {

    val readAllData: LiveData<List<Lavoura>> = lavouraDao.readAllData()

    suspend fun addLavoura(lavoura: Lavoura){
        lavouraDao.addLavoura(lavoura)
    }
}