package com.tanveer.handsonapplication.ui.dashboard.data.repository

import com.tanveer.handsonapplication.ui.dashboard.data.entities.QuoteEntity
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getQuotes(page: Int): Flow<QuoteEntity>
}