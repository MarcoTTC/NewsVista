package br.com.marcottc.newsvista.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.marcottc.newsvista.model.remote.TopArticleRemote
import br.com.marcottc.newsvista.model.mock.MockGenerator
import br.com.marcottc.newsvista.model.remote.NewsRetrievalRemote
import br.com.marcottc.newsvista.network.nytimes.NyTimesNewsRetriever
import kotlinx.coroutines.launch

class NewsVistaViewModel: ViewModel() {

    private val _currentArticleList: MutableLiveData<List<TopArticleRemote>> = MutableLiveData(MockGenerator.generateTopArticleData())
    val currentArticleList: LiveData<List<TopArticleRemote>>
        get() = _currentArticleList

    suspend fun fetchTopArticles(): NewsRetrievalRemote? {
        return NyTimesNewsRetriever.getTopStoriesSectionHomeList()
    }
}