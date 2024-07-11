package br.com.marcottc.newsvista.network.nytimes

import br.com.marcottc.newsvista.util.nyBaseUrl
import br.com.marcottc.newsvista.util.nyQueryParamApiKey
import br.com.marcottc.newsvista.util.nySectionHome
import br.com.marcottc.newsvista.util.nyServicePath
import br.com.marcottc.newsvista.util.nyServiceVersion
import br.com.marcottc.newsvista.util.nyTimesAppId
import br.com.marcottc.newsvista.util.nyTopStories
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class NyTimesNewsRetriever {

    companion object {

        fun getTopStoriesSectionHomeList(): String {
            val httpUrlBuilder = baseUrlBuilder()
                .addPathSegment(nyTopStories)
                .addPathSegment(nyServiceVersion)
                .addPathSegment(nySectionHome)
                .addQueryParameter(nyQueryParamApiKey, nyTimesAppId)

            return genericHttpGetRequest(httpUrlBuilder)
        }

        private fun genericHttpGetRequest(httpUrlBuilder: HttpUrl.Builder): String {
            val client = OkHttpClient()

            val request = Request.Builder()
                .url(httpUrlBuilder.build())
                .method("GET", null)
                .build()

            val response = client.newCall(request).execute()

            return response.body?.string() ?: ""
        }

        private fun baseUrlBuilder(): HttpUrl.Builder {
            return HttpUrl.Builder()
                .scheme("https")
                .host(nyBaseUrl)
                .addPathSegment(nyServicePath)
        }
    }
}