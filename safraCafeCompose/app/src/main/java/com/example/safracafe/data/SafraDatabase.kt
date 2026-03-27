package com.example.safracafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.safracafe.data.dao.LavouraDao
import com.example.safracafe.data.entities.Lavoura

@Database(entities = [Lavoura::class], version = 1, exportSchema = false)
abstract class SafraDatabase: RoomDatabase() {
    abstract fun lavouraDao(): LavouraDao
    companion object{
        @Volatile
        private var Instance: SafraDatabase? = null

        //verifica se ja existe a Database, se não é criado uma
        fun getDatabase(context: Context): SafraDatabase{
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    SafraDatabase::class.java,
                    "SafraDatabase"
                ).build().also{Instance = it}
            }
        }
    }
}