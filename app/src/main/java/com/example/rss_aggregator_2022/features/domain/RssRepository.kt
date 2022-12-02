package com.example.rss_aggregator_2022.features.domain

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either

interface RssRepository {
    fun createRss(name:String,urlRss:String)
    suspend fun getSourceRss(): Either<ErrorApp, List<Rss>>
}