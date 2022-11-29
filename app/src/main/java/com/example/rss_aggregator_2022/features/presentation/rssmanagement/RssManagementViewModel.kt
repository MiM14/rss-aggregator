package com.example.rss_aggregator_2022.features.presentation.rssmanagement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rss_aggregator_2022.features.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel(private val saveRssUseCase: SaveRssUseCase) : ViewModel() {

    private val rssManagementPublisher: MutableLiveData<RssUiState> by lazy {
        MutableLiveData<RssUiState>()
    }

    fun saveRss(name: String, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveRssUseCase.execute(name, url)
            rssManagementPublisher.postValue(
                RssUiState(true)
            )
        }
    }

    data class RssUiState(val isSuccess: Boolean = false)
}