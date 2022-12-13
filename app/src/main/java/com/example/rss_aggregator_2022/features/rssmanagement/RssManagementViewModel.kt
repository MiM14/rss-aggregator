package com.example.rss_aggregator_2022.features.rssmanagement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rss_aggregator_2022.app.domain.ErrorApp
import com.example.rss_aggregator_2022.features.domain.GetSourceRssUseCase
import com.example.rss_aggregator_2022.features.domain.Rss
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagementViewModel(private val getSourceRssUseCase: GetSourceRssUseCase) : ViewModel() {
    private val _managerUiState = MutableLiveData(ManagerUiState())
    val managerUiState = _managerUiState

    fun obtainRss() {
        viewModelScope.launch(Dispatchers.IO) {
            getSourceRssUseCase.invoke().collect { either ->
                either.fold({ errorApp ->
                    _managerUiState.postValue(
                        ManagerUiState(error = errorApp)
                    )
                }, { feed ->
                    _managerUiState.postValue(
                        ManagerUiState(managerFeed = feed, error = null)
                    )
                }
                )
            }
        }
    }

    data class ManagerUiState(val managerFeed: List<Rss>? = null, val error: ErrorApp? = null)
}