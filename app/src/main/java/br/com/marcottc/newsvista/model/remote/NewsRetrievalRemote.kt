package br.com.marcottc.newsvista.model.remote

import com.google.gson.annotations.SerializedName

data class NewsRetrievalRemote(
    val status: String,
    val copyright: String,
    val section: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val resultList: List<TopArticleRemote>
)