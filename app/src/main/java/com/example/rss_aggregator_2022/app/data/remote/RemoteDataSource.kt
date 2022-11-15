package com.example.rss_aggregator_2022.app.data.remote

import retrofit2.Response

class RemoteDataSource(url: String): ApiServices {

    override suspend fun getRss(url: String): Response<RssApiModel> {
        TODO("")
    }
}