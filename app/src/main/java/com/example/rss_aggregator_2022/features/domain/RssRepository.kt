package com.example.rss_aggregator_2022.features.domain

interface RssRepository {
    fun createRss(name:String,urlRss:String)
}