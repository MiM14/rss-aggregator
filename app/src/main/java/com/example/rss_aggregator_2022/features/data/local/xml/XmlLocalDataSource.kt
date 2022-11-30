package com.example.rss_aggregator_2022.features.data.local.xml

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.app.commons.KSerializer
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.domain.Rss
import com.google.gson.Gson

class XmlLocalDataSource(private val sharedPref: SharedPreferences, private val kSerializer: KSerializer): LocalDataSource {
    private val editor = sharedPref.edit()
    val gson = Gson()
    override fun saveRss(name: String, urlRss: String) {
        editor.putString(urlRss, kSerializer.toJson(Rss(name,urlRss),Rss::class.java))
        editor.apply()
    }
    fun getList(): MutableList<Rss> {
        val rssList = mutableListOf<Rss>()
        sharedPref.all.map{
            rssList.add(gson.fromJson(it.value as String, Rss::class.java))
        }
        return rssList
    }
}