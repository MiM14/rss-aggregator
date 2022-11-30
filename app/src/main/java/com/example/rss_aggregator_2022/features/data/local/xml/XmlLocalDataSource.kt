package com.example.rss_aggregator_2022.features.data.local.xml

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.app.commons.KSerializer
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.domain.Rss

class XmlLocalDataSource(private val sharedPref: SharedPreferences, private val kSerializer: KSerializer): LocalDataSource {
    private val editor = sharedPref.edit()

    override fun saveRss(name: String, urlRss: String) {
        editor.putString(urlRss, kSerializer.toJson(Rss(name,urlRss),Rss::class.java))
        editor.apply()
    }

    override fun getUserRssList(): List<Rss> {
        val rssFeed = mutableListOf<Rss>()
        sharedPref.all.map{
            rssFeed.add(kSerializer.fromJson(it.value as String, Rss::class.java))
        }
        return rssFeed
    }
}