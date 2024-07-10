package br.com.marcottc.newsvista.model.remote

data class TopArticleRemote(
    val section: String,
    val subsection: String,
    val title: String,
    val abstract: String,
    val url: String,
    val uri: String,
    val byline: String,
    val itemType: String,
    val updatedDate: String,
    val createdDate: String,
    val publishedDate: String,
    val materialTypeFacet: String,
    val kicker: String,
    val desFacet: List<String>,
    val orgFacet: List<String>,
    val perFacet: List<String>,
    val geoFacet: List<String>,
    val multimediaList: List<MultimediaRemote>,
    val shortUrl: String
)