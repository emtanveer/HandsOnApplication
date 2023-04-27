package com.tanveer.handsonapplication.shared.network.api

import android.util.Log
import com.fpremake.utils.network_utils.NoConnectivityException
import com.fpremake.utils.network_utils.NoInternetException
import com.tanveer.handsonapplication.ui.dashboard.data.entities.QuoteEntity
import com.tanveer.handsonapplication.ui.dashboard.data.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

//class QuoteServiceIml constructor(private val retrofit: Retrofit) : QuoteService {
//
//    private val endpoint by lazy { retrofit.create(QuoteService::class.java) }
//
//    //    override suspend fun quotes(page: Int): Response<QuoteList> = endpoint.quotes(page)
//    override suspend fun quotes(page: Int): Response<QuoteList> {
//            return endpoint.quotes(page)
//    }
//}

class QuoteRepositoryIml(private val quoteService: QuoteService) : QuoteRepository {
    //private val endpoint by lazy { retrofit.create(QuoteService::class.java) }

    override suspend fun getQuotes(page: Int): Flow<QuoteEntity> {
        return try {
            val quoteFlow = (quoteService.quotes(page = page))
            flowOf(quoteFlow)

        } catch (e: NoConnectivityException) {
            Log.e("NoConnectivityException", e.message)
            flow { }
        } catch (e: NoInternetException) {
            Log.e("NoInternetException", e.message)
            flow { }
        } catch (e: Exception) {
            Log.e("Exception", e.message ?: "Unknown Exception")
            flow { }
        }

//        endpoint.quotes(page)
    }

}