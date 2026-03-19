package com.example.safracafe.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LavouraDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLavoura(lavoura: Lavoura)

    @Query("SELECT * FROM lavouras_table")
    fun readAllData(): LiveData<List<Lavoura>>

}