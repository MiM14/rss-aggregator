package com.example.rss_aggregator_2022.features.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.rss_aggregator_2022.app.commons.KSerializer
import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.app.functional.Either
import com.example.rss_aggregator_2022.app.functional.right
import com.example.rss_aggregator_2022.features.data.local.LocalDataSource
import com.example.rss_aggregator_2022.features.domain.Rss
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DSLocalDataSource(private val context: Context, private val serializer: KSerializer) :LocalDataSource {
    private val Context.dataStore by preferencesDataStore(
        name = "name_datastore_file"
    )

    override suspend fun saveRss(name: String, urlRss: String) {
        context.dataStore.edit {
            it[stringPreferencesKey(urlRss)] = serializer.toJson(Rss(urlRss,name))
        }
    }

    override fun obtain(): Flow<Either<ErrorApp, List<Rss>>> {
        return context.dataStore.data.map{ preferences ->
            preferences.asMap().values.map {
                serializer.fromJson(it as String, Rss::class.java)
            }.right()
        }
    }


}