package br.com.marcottc.newsvista.state

import br.com.marcottc.newsvista.model.remote.TopStoriesNewsRetrievalRemote

class NewsRetrievalState(
    private var state: State = State.LOADING,
    private var newsRetrieval: TopStoriesNewsRetrievalRemote? = null,
    private var newsTagList: List<String> = emptyList(),
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

    fun getNewsTagList(): List<String> = newsTagList

    fun getErrorMessage(): String? {
        return if (state == State.ERROR) {
            errorMessage
        } else {
            null
        }
    }


}