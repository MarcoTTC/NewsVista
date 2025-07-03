package br.com.marcottc.newsvista.viewmodel

//import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.marcottc.newsvista.intent.NewsRetrievalIntent
import br.com.marcottc.newsvista.model.remote.TopStoriesArticleRemote
import br.com.marcottc.newsvista.network.service.NyTimesNewsRetriever
import br.com.marcottc.newsvista.state.NewsRetrievalState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class NewsVistaViewModel: ViewModel() {

    private val _currentNewsRetrievalState: MutableStateFlow<NewsRetrievalState> = MutableStateFlow(
        value = NewsRetrievalState()
    )
    val currentNewsRetrievalState: StateFlow<NewsRetrievalState> = _currentNewsRetrievalState.asStateFlow()

    init {
        handleIntent(NewsRetrievalIntent.INIT)
    }

    fun handleIntent(intent: NewsRetrievalIntent) {
        viewModelScope.launch {
            when (intent) {
                NewsRetrievalIntent.INIT -> {
                    _currentNewsRetrievalState.emit(
                        NewsRetrievalState()
                    )
                }

                NewsRetrievalIntent.FETCH_ARTICLES -> {
                    fetchTopArticles()
                }
            }
        }
    }

    private suspend fun fetchTopArticles() = withContext(Dispatchers.IO) {
        _currentNewsRetrievalState.emit(NewsRetrievalState())
        try {
            val newsRetrieval = NyTimesNewsRetriever.getTopStoriesSectionHomeList()
            if (newsRetrieval != null) {
                val newsTagList = buildNewsTagListFromTopStoriesList(newsRetrieval.resultList)

                _currentNewsRetrievalState.emit(NewsRetrievalState(
                    state = NewsRetrievalState.State.SUCCESS,
                    newsTagList = newsTagList,
                    newsRetrieval = newsRetrieval
                ))
            } else {
                _currentNewsRetrievalState.emit(NewsRetrievalState(
                    state = NewsRetrievalState.State.ERROR,
                    errorMessage = "Failure when retrieving the news data"
                ))
            }
        } catch (e: Exception) {
            _currentNewsRetrievalState.emit(NewsRetrievalState(
                state = NewsRetrievalState.State.ERROR,
                errorMessage = e.message ?: "Failure when retrieving the news data"
            ))
        }
    }

    private fun buildNewsTagListFromTopStoriesList(articleList: List<TopStoriesArticleRemote>): List<String> {
        return  articleList.map { article ->
            String.format("#%s", article.section.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            })
        }.distinct()
    }
}