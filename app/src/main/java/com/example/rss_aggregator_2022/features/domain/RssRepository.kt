package com.example.rss_aggregator_2022.features.domain

interface RssRepository {
    fun save(name:String,urlRss:String)
}