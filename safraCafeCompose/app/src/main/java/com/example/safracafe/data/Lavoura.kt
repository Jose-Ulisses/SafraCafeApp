package com.example.safracafe.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lavouras_table")
data class Lavoura(
    @PrimaryKey(autoGenerate = true) val lavouraId: Int,
    @ColumnInfo(name = "nomeLavoura") val nomeLavoura: String?
)