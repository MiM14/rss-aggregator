package com.example.rss_aggregator_2022.features.rssmanagement

import android.content.SharedPreferences
import com.example.rss_aggregator_2022.features.data.RssDataRepository
import com.example.rss_aggregator_2022.features.data.local.xml.XmlLocalDataSource
import com.example.rss_aggregator_2022.features.domain.SaveRssUseCase

class RssManagementFactory {
    fun injectRssManagementViewModel(sharedPreferences: SharedPreferences): UserFormViewModel {
        return UserFormViewModel(
            SaveRssUseCase(
                RssDataRepository(
                    XmlLocalDataSource(
                        sharedPreferences
                    )
                )
            )
        )
    }
}