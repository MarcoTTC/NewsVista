package br.com.marcottc.newsvista.model.remote

data class NewsRetrievalRemote(
    val status: String,
    val copyright: String,
    val section: String,
    val lastUpdated: String,
    val numResults: Int,
    val resultList: List<TopArticleRemote>
)