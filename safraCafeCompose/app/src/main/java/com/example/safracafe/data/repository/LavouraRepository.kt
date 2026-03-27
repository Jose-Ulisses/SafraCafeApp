package com.example.safracafe.data.repository

import com.example.safracafe.data.entities.Lavoura
import kotlinx.coroutines.flow.Flow

interface LavouraRepository {
    fun getAllLavouras(): Flow<List<Lavoura>>

    fun getLavoura(id: Int): Flow<Lavoura?>

    suspend fun insertLavoura(lavoura: Lavoura)

    suspend fun deleteLavoura(lavoura: Lavoura)

    suspend fun updateLavoura(lavoura: Lavoura)
}