package com.example.rss_aggregator_2022.features.domain

class DeleteSourceRssUseCase(private val repository: RssRepository) {
    suspend operator fun invoke(urlRss: String) {
        repository.deleteRss(urlRss)
    }
}