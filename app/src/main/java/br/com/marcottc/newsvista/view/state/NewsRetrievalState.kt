package br.com.marcottc.newsvista.view.state

import br.com.marcottc.newsvista.model.remote.TopStoriesNewsRetrievalRemote

class NewsRetrievalState(
    private var state: State = State.LOADING,
    private var newsRetrieval: TopStoriesNewsRetrievalRemote? = null,
    private var errorMessage: String? = null
) {
    enum class State {
        LOADING, SUCCESS, ERROR
    }

    fun getState(): State {
        return state
    }

    fun getNewsRetrieval(): TopStoriesNewsRetrievalRemote? {
        return if (state == State.SUCCESS) {
            newsRetrieval
        } else {
            null
        }
    }

    fun getErrorMessage(): String? {
        return if (state == State.ERROR) {
            errorMessage
        } else {
            null
        }
    }

    fun setStateLoading() {
        state = State.LOADING
    }

    fun setStateSuccess(newsRetrieval: TopStoriesNewsRetrievalRemote) {
        state = State.SUCCESS
        this.newsRetrieval = newsRetrieval
    }

    fun setStateError(errorMessage: String) {
        state = State.ERROR
        this.errorMessage = errorMessage
    }
}