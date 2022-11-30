package com.example.rss_aggregator_2022.features.domain

class GetSourceRssUseCase(private val repository: RssRepository){
    fun execute(): List<Rss> =
        repository.getSourceRss()
}