package br.com.marcottc.newsvista.model

data class MultimediaRemote(
    val url: String,
    val format: String,
    val height: Int,
    val width: Int,
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String
)