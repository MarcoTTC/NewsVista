package br.com.marcottc.newsvista.network.nytimes

import br.com.marcottc.newsvista.model.remote.NewsRetrievalRemote
import br.com.marcottc.newsvista.util.nyBaseUrl
import br.com.marcottc.newsvista.util.nyQueryParamApiKey
import br.com.marcottc.newsvista.util.nySectionHome
import br.com.marcottc.newsvista.util.nyServicePath
import br.com.marcottc.newsvista.util.nyServiceVersion
import br.com.marcottc.newsvista.util.nyTimesAppId
import br.com.marcottc.newsvista.util.nyTopStories
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class NyTimesNewsRetriever {

    companion object {

        fun getTopStoriesSectionHomeList(): NewsRetrievalRemote? {
            val httpUrl = baseUrlBuilder()
                .addPathSegment(nyTopStories)
                .addPathSegment(nyServiceVersion)
                .addPathSegment(nySectionHome)
                .addQueryParameter(nyQueryParamApiKey, nyTimesAppId)
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
                .host(nyBaseUrl)
                .addPathSegment(nyServicePath)
        }
    }
}