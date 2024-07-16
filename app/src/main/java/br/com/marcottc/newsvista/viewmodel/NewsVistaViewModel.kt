package br.com.marcottc.newsvista.viewmodel

import androidx.lifecycle.ViewModel
import br.com.marcottc.newsvista.model.remote.TopArticleRemote
import br.com.marcottc.newsvista.network.service.NyTimesNewsRetriever
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsVistaViewModel: ViewModel() {

    private val _currentArticleList: MutableStateFlow<List<TopArticleRemote>> = MutableStateFlow(emptyList())
    val currentArticleList: StateFlow<List<TopArticleRemote>> = _currentArticleList.asStateFlow()

    suspend fun fetchTopArticles() {
        _currentArticleList.value = NyTimesNewsRetriever.getTopStoriesSectionHomeList()?.resultList ?: emptyList()
    }
}