package com.example.rss_aggregator_2022.app.data.remote

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class RetrofitClient(url: String) {
    fun buildApiEndPoints(url: String) = buildApiClient(url).create(ApiServices::class.java)

    private val apiEndPoints: ApiServices

    init {
        apiEndPoints = buildApiEndPoints(url)
    }

    fun buildApiClient(url: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }
}