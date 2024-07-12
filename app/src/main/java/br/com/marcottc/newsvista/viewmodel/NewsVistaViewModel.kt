package br.com.marcottc.newsvista.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marcottc.newsvista.model.remote.TopArticleRemote
import br.com.marcottc.newsvista.network.nytimes.NyTimesNewsRetriever

class NewsVistaViewModel: ViewModel() {

    private val _currentArticleList: MutableLiveData<List<TopArticleRemote>> = MutableLiveData()
    val currentArticleList: LiveData<List<TopArticleRemote>>
        get() = _currentArticleList

    suspend fun fetchTopArticles() {
        _currentArticleList.postValue(NyTimesNewsRetriever.getTopStoriesSectionHomeList()?.resultList)
    }
}