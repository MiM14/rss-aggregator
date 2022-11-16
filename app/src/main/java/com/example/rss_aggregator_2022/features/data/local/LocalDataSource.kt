package com.example.rss_aggregator_2022.features.data.local

interface LocalDataSource {
    fun saveRss(name:String,urlRss:String)
}