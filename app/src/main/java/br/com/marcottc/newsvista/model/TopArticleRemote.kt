package br.com.marcottc.newsvista.model

data class TopArticleRemote(
    val section: String,
    val subsection: String,
    val title: String,
    val abstract: String,
    val url: String,
    val byline: String,
    val itemType: String,
    val updatedDate: String,
    val createdDate: String
)