package br.com.marcottc.newsvista.viewmodel

import androidx.lifecycle.ViewModel
import br.com.marcottc.newsvista.network.service.NyTimesNewsRetriever
import br.com.marcottc.newsvista.view.NewsRetrievalState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsVistaViewModel: ViewModel() {

    private val _currentNewsRetrievalState: MutableStateFlow<NewsRetrievalState> = MutableStateFlow(
        value = NewsRetrievalState()
    )
    val currentNewsRetrievalState: StateFlow<NewsRetrievalState> = _currentNewsRetrievalState.asStateFlow()

    suspend fun fetchTopArticles() {
        _currentNewsRetrievalState.value.setStateLoading()
        try {
            val newsRetrieval = NyTimesNewsRetriever.getTopStoriesSectionHomeList()
            if (newsRetrieval != null) {
                _currentNewsRetrievalState.value.setStateSuccess(newsRetrieval)
            } else {
                _currentNewsRetrievalState.value.setStateError("Failure when retrieving the news data")
            }
        } catch (e: Exception) {
            _currentNewsRetrievalState.value.setStateError(e.message ?: "Failure when retrieving the news data")
        }
    }
}