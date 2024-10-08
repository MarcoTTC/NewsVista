package br.com.marcottc.newsvista.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.marcottc.newsvista.intent.NewsRetrievalIntent
import br.com.marcottc.newsvista.network.service.NyTimesNewsRetriever
import br.com.marcottc.newsvista.state.NewsRetrievalState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsVistaViewModel: ViewModel() {

    private val _currentNewsRetrievalState: MutableStateFlow<NewsRetrievalState> = MutableStateFlow(
        value = NewsRetrievalState()
    )
    val currentNewsRetrievalState: StateFlow<NewsRetrievalState> = _currentNewsRetrievalState.asStateFlow()

    init {
        handleIntent(NewsRetrievalIntent.INIT)
    }

    fun handleIntent(intent: NewsRetrievalIntent) {
        when (intent) {
            NewsRetrievalIntent.INIT -> {
                _currentNewsRetrievalState.value.setStateLoading()
            }
            NewsRetrievalIntent.FETCH_ARTICLES -> {
                viewModelScope.launch {
                    fetchTopArticles()
                }
            }
        }
    }

    private suspend fun fetchTopArticles() = withContext(Dispatchers.IO) {
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