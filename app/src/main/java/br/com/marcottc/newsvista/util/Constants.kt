package br.com.marcottc.newsvista.util

// If this val is an empty string, you must access NY Times developer portal at
// "https://developer.nytimes.com/", register yourself an account, create an app,
// retrieve the app id for your app, and add it in this val
const val nyTimesAppId: String = ""

// Values for the NY Times Dev API
const val nyBaseUrl: String = "api.nytimes.com"
const val nyServicePath: String = "svc"
const val nyTopStories: String = "topstories"
const val nyServiceVersion: String = "v2"
const val nySectionHome: String = "home.json"
const val nyQueryParamApiKey: String = "api-key"