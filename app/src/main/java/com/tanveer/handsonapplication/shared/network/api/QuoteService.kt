package com.tanveer.handsonapplication.shared.network.api


import com.tanveer.handsonapplication.ui.dashboard.data.entities.QuoteEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun quotes(@Query("page") page: Int) : QuoteEntity
}