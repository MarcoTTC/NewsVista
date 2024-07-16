package br.com.marcottc.newsvista.view

import br.com.marcottc.newsvista.model.remote.NewsRetrievalRemote

class NewsRetrievalState(
    private var state: State = State.LOADING,
    private var newsRetrieval: NewsRetrievalRemote? = null,
    private var errorMessage: String? = null
) {
    enum class State {
        LOADING, SUCCESS, ERROR
    }

    fun getState(): State {
        return state
    }

    fun getNewsRetrieval(): NewsRetrievalRemote? {
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

    fun setStateSuccess(newsRetrieval: NewsRetrievalRemote) {
        state = State.SUCCESS
        this.newsRetrieval = newsRetrieval
    }

    fun setStateError(errorMessage: String) {
        state = State.ERROR
        this.errorMessage = errorMessage
    }
}