package com.example.safracafe.data.repository

import com.example.safracafe.data.dao.LavouraDao
import com.example.safracafe.data.entities.Lavoura
import kotlinx.coroutines.flow.Flow

class OfflineLavourasRepository(private val lavouraDao: LavouraDao) : LavouraRepository {
    override fun getAllLavouras(): Flow<List<Lavoura>> = lavouraDao.getAllLavouras()

    override fun getLavoura(id: Int): Flow<Lavoura?> = lavouraDao.getLavoura(id)

    override suspend fun insertLavoura(lavoura: Lavoura) = lavouraDao.insert(lavoura)

    override suspend fun deleteLavoura(lavoura: Lavoura) = lavouraDao.delete(lavoura)

    override suspend fun updateLavoura(lavoura: Lavoura) = lavouraDao.update(lavoura)
}