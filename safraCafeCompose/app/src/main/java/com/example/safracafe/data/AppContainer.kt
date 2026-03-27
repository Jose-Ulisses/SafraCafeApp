package com.example.safracafe.data

import android.content.Context
import com.example.safracafe.data.repository.LavouraRepository
import com.example.safracafe.data.repository.OfflineLavourasRepository

interface AppContainer{
    val lavouraRepository: LavouraRepository
}

class AppDataContainer(private val context: Context): AppContainer{
    override val lavouraRepository: LavouraRepository by lazy{
        OfflineLavourasRepository(SafraDatabase.getDatabase(context).lavouraDao())
    }
}
