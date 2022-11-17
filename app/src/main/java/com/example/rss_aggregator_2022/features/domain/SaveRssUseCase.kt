package com.example.rss_aggregator_2022.features.domain

class SaveRssUseCase(private val repository: RssRepository){
    fun execute(name:String,urlRss:String)=
        repository.save(name,urlRss)

}