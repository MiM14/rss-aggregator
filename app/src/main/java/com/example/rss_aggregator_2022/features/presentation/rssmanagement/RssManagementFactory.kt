package com.example.rss_aggregator_2022.features.presentation.rssmanagement

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.app.commons.GsonJSerializer
import com.example.rss_aggregator_2022.features.data.RssDataRepository
import com.example.rss_aggregator_2022.features.data.local.xml.XmlLocalDataSource
import com.example.rss_aggregator_2022.features.domain.SaveRssUseCase

class RssManagementFactory {
    fun saveUserRss(sharedPreferences: SharedPreferences): RssManagementViewModel {
        return RssManagementViewModel(
            SaveRssUseCase(
                RssDataRepository(
                    XmlLocalDataSource(
                        sharedPreferences,
                        GsonJSerializer()
                    )
                )
            )
        )
    }
}