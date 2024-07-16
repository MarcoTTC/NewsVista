package br.com.marcottc.newsvista.network.service

import br.com.marcottc.newsvista.model.remote.NewsRetrievalRemote
import br.com.marcottc.newsvista.util.nyTimesAppId
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class NyTimesNewsRetriever {

    companion object {

        private const val NY_BASE_URL: String = "api.nytimes.com"
        private const val NY_SERVICE_PATH: String = "svc"
        private const val NY_TOP_STORIES: String = "topstories"
        private const val NY_SERVICE_VERSION: String = "v2"
        private const val NY_SECTION_HOME: String = "home.json"
        private const val NY_QUERY_PARAM_API_KEY: String = "api-key"

        fun getTopStoriesSectionHomeList(): NewsRetrievalRemote? {
            val httpUrl = baseUrlBuilder()
                .addPathSegment(NY_TOP_STORIES)
                .addPathSegment(NY_SERVICE_VERSION)
                .addPathSegment(NY_SECTION_HOME)
                .addQueryParameter(NY_QUERY_PARAM_API_KEY, nyTimesAppId)
                .build()

            val responseBody = genericHttpGetRequest(httpUrl) ?: return null

            val gson = Gson()
            val newsRetrieval = gson.fromJson(responseBody, NewsRetrievalRemote::class.java)
            return newsRetrieval
        }

        private fun genericHttpGetRequest(httpUrl: HttpUrl): String? {
            val request = Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .build()

            val client = OkHttpClient.Builder().build()
            val response = client.newCall(request).execute()
            return response.body?.string()
        }

        private fun baseUrlBuilder(): HttpUrl.Builder {
            return HttpUrl.Builder()
                .scheme("https")
                .host(NY_BASE_URL)
                .addPathSegment(NY_SERVICE_PATH)
        }
    }
}