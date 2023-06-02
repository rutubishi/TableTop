package com.rutubishi.common.data.graphql

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

object GraphQLClient {
    private val okHttp =  OkHttpClient
        .Builder()
        .addInterceptor {
            val original = it.request()
            val request = original.newBuilder()
                .method(original.method, original.body)
                .build()
            it.proceed(request)
        }
        .build()

    private const val SERVER_URL = "http://192.168.0.101:3000/graphql"

    val client = ApolloClient
        .Builder()
        .okHttpClient(okHttp)
        .serverUrl(SERVER_URL)
        .build()
}