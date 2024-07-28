package br.com.marcottc.newsvista.model.remote

import com.google.gson.annotations.SerializedName

data class TopStoriesArticleRemote(
    val section: String,
    val subsection: String,
    val title: String,
    val abstract: String,
    val url: String,
    val uri: String,
    val byline: String,
    @SerializedName("item_type")
    val itemType: String,
    @SerializedName("updated_date")
    val updatedDate: String,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("material_type_facet")
    val materialTypeFacet: String,
    val kicker: String,
    @SerializedName("des_facet")
    val desFacet: List<String>,
    @SerializedName("org_facet")
    val orgFacet: List<String>,
    @SerializedName("per_facet")
    val perFacet: List<String>,
    @SerializedName("geo_facet")
    val geoFacet: List<String>,
    @SerializedName("multimedia")
    val multimediaList: List<MultimediaRemote>?,
    @SerializedName("short_url")
    val shortUrl: String
)