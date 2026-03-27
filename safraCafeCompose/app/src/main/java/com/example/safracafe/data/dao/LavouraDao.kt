package com.example.safracafe.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.safracafe.data.entities.Lavoura
import kotlinx.coroutines.flow.Flow

@Dao
interface LavouraDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(lavoura: Lavoura)

    @Update
    suspend fun update(lavoura: Lavoura)

    @Delete
    suspend fun delete(lavoura: Lavoura)

    @Query("SELECT * FROM lavouras_table WHERE lavouraId = :id")
    fun getLavoura(id: Int): Flow<Lavoura>

    @Query("SELECT * FROM lavouras_table ORDER BY nomeLavoura ASC")
    fun getAllLavouras(): Flow<List<Lavoura>>
}