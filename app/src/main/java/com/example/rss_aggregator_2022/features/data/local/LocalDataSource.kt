package com.example.rss_aggregator_2022.features.data.local

import com.example.rss_aggregator_2022.features.domain.Rss

interface LocalDataSource {
    fun saveRss(name:String,urlRss:String)
    fun getUserRssList():List<Rss>
}