package com.example.rss_aggregator_2022.features.domain

import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either

class GetSourceRssUseCase(private val repository: RssRepository){
    suspend fun execute(): Either<ErrorApp, List<Rss>> =
        repository.getSourceRss()
}