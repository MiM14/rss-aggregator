package com.example.rss_aggregator_2022.features.data.remote

import org.simpleframework.xml.*

@Root(name = "rss", strict = false)
data class RssApiModel @JvmOverloads constructor(
    @field:ElementList(name = "item", inline = true, required = false)
    @param:ElementList(name = "item", inline = true, required = false)
    @field:Path("channel")
    @param:Path("channel")
    var items: List<ItemApiModel>? = null
)

@Root(name = "item", strict = false)
data class ItemApiModel @JvmOverloads constructor(
    @field:Path("title")
    @param:Path("title")
    @field:Text(required = false)
    @param:Text(required = false)
    var title: String? = null,

    @field:Path("description")
    @param:Path("description")
    @field:Text(required = false)
    @param:Text(required = false)
    var description: String? = null,

    @field:Path("link")
    @param:Path("link")
    @field:Text(required = false)
    @param:Text(required = false)
    var link: String? = null,

    @field:Path("pubDate")
    @param:Path("pubDate")
    @field:Text(required = false)
    @param:Text(required = false)
    var pubDate: String? = null,

    @field:Path("dc:creator")
    @param:Path("dc:creator")
    @field:Text(required = false)
    @param:Text(required = false)
    var creator: String? = null,
)