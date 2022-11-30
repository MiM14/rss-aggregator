package com.example.rss_aggregator_2022.features.domain

class GetSourceRssUseCase(private val repository: RssRepository) {
    suspend fun execute(): List<Rss> =
        repository.getSourceRss()
}