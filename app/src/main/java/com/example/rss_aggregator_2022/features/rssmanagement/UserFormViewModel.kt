package com.example.rss_aggregator_2022.features.rssmanagement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rss_aggregator_2022.features.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserFormViewModel(private val saveRssUseCase: SaveRssUseCase) : ViewModel() {

    private val _formUiState = MutableLiveData(FormUiState())
    val formUiState: LiveData<FormUiState> = _formUiState

    fun saveRss(name: String, url: String) {
        viewModelScope.launch {
            saveRssUseCase.invoke(name, url)
            _formUiState.postValue(
                FormUiState(
                    isSuccess = true
                )
            )
        }
    }

    data class FormUiState(val isSuccess: Boolean = false)
}