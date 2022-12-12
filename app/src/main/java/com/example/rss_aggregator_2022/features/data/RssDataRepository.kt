package com.example.rss_aggregator_2022.features.data

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.domain.Rss
import com.example.rss_aggregator_2022.features.domain.RssRepository
import kotlinx.coroutines.flow.Flow

class RssDataRepository(private val localSource: LocalDataSource) :RssRepository{
    override suspend fun createRss(name: String, urlRss: String) =
        localSource.saveRss(name,urlRss)

    override suspend fun getSourceRss(): Flow<Either<ErrorApp, List<Rss>>> =
        localSource.obtain()
}