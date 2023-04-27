package com.tanveer.handsonapplication

import com.tanveer.handsonapplication.shared.network.api.QuoteRepositoryIml
import com.tanveer.handsonapplication.shared.network.api.QuoteService
import com.tanveer.handsonapplication.shared.network.api.RetrofitInstance
import com.tanveer.handsonapplication.ui.dashboard.data.entities.QuoteEntity
import kotlinx.coroutines.debug.junit4.CoroutinesTimeout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit

class RetrofitClientTest {

    @get:Rule
    public val timeout = CoroutinesTimeout.seconds(6)

//    @Test
//    fun `test retrofit instance and validate BASE URL is same as intended`() {
//        //Getting the retrofit Instance
//        val instance: Retrofit = RetrofitInstance.retrofit
//
//        //Assert that, Retrofit's base url matches to our BASE_URL
//        assert(instance.baseUrl().toUrl().toString() == BuildConfig.BASE_URL)
//    }

    @Test
    fun `test API calling to get latest quotes from the server`(): Unit = runBlocking {
        //Getting the retrofit Instance and then Get an instance of QuoteServiceIml(implementation) by providing the Retrofit instance
        val retrofitInstance: Retrofit = RetrofitInstance.retrofit
        val quoteService = retrofitInstance.create(QuoteService::class.java)
        val instance: QuoteRepositoryIml = QuoteRepositoryIml(quoteService)

        //Create a new request for our API calling
        val pageNumber = 2;

        var response: Flow<QuoteEntity>? = null
        //Execute the API call
        val job = launch { response = instance.getQuotes(page = pageNumber) }
        job.join() //Suspends the coroutine until this job is complete


        response?.collect {
            val responseWrapper = it
            assert(responseWrapper.results != null)
        }


//        //Check for error body
//        val errorBody = response?.errorBody()
//        assert(errorBody == null)
//        //Check for success body
//        val responseWrapper = response?.body()
//        assert(responseWrapper != null)
//        //Log.e("API test", responseWrapper.toString())
//        assert(response?.body()?.results?.isNotEmpty() == true)
    }
}