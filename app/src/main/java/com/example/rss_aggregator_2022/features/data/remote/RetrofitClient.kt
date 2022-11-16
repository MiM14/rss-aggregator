package com.example.rss_aggregator_2022.features.data.remote


import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RetrofitClient(url: String) {
    private val apiEndPoints: ApiServices

    private fun buildApiEndPoints(url: String) = buildApiClient(url).create(ApiServices::class.java)

    init {
        apiEndPoints = buildApiEndPoints(url)
    }

    private fun buildApiClient(url: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }
    suspend fun getRss(url: String): Either<ErrorApp, RssApiModel?> {
        val response = apiEndPoints.getRss(url).body()
        return if(response == null){
            Either.Left(ErrorApp.DataError())
        }else{
            Either.Right(response)
        }
    }
}