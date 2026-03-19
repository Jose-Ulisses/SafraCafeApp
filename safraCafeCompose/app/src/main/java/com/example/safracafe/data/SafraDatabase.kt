package com.example.safracafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Lavoura::class], version = 1, exportSchema = false)
abstract class SafraDatabase: RoomDatabase() {

    abstract fun lavouraDao(): LavouraDao

    companion object{
        @Volatile
        private var INSTANCE: SafraDatabase? = null

        //verifica se ja existe a Database, se não é criado uma
        fun getDatabase(context: Context): SafraDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SafraDatabase::class.java,
                    "lavouras_table"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}