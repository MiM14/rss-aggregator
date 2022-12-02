package com.example.rss_aggregator_2022.features.data.local

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import com.example.rss_aggregator_2022.features.domain.Rss

interface LocalDataSource {
    fun saveRss(name:String,urlRss:String)
    suspend fun getUserRssList():Either<ErrorApp,List<Rss>>
}