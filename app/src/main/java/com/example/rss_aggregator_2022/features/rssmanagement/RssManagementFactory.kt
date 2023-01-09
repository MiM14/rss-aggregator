package com.example.rss_aggregator_2022.features.rssmanagement

import android.content.Context
import com.example.rss_aggregator_2022.app.commons.GsonJSerializer
import com.example.rss_aggregator_2022.features.data.RssDataRepository
import com.example.rss_aggregator_2022.features.data.local.datastore.DSLocalDataSource
import com.example.rss_aggregator_2022.features.domain.SaveRssUseCase

class RssManagementFactory {

    fun injectRssManagementViewModel(context: Context): UserFormViewModel {
        return UserFormViewModel(
            SaveRssUseCase(
                RssDataRepository(
                    DSLocalDataSource(
                        context,GsonJSerializer()
                    )
                )
            )
        )
    }
}