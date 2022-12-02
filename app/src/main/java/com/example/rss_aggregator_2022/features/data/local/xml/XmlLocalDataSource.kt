package com.example.rss_aggregator_2022.features.data.local.xml

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource

class XmlLocalDataSource(sharedPref: SharedPreferences): LocalDataSource {
    private val editor = sharedPref.edit()

    override fun saveRss(name: String, urlRss: String) {
        editor.putString(urlRss, name)
        editor.apply()
    }
}