package com.example.rss_aggregator_2022.features.data.local.xml

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.domain.Rss

class XmlLocalDataSource(private val sharedPref: SharedPreferences): LocalDataSource {
    private val editor = sharedPref.edit()

    override fun saveRss(name: String, urlRss: String) {
        editor.putString(urlRss,name)
        editor.apply()
    }

    override fun getUserRssList(): List<Rss> {
        val rssFeed = mutableListOf<Rss>()
        sharedPref.all.map{
            rssFeed.add(Rss(it.value.toString(),sharedPref.getString(it.key,it.value.toString())!!))
        }
        return rssFeed
    }
}