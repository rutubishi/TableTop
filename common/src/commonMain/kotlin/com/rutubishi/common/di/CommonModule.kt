package com.rutubishi.common.di

import com.apollographql.apollo3.ApolloClient
import com.rutubishi.common.data.graphql.GraphQLClient
import com.rutubishi.common.data.repository.AuthRepository
import com.rutubishi.common.data.repository.IAuthRepository
import org.koin.dsl.module

val CommonModule = module {
    single <ApolloClient> { GraphQLClient.client }
    single <IAuthRepository> { AuthRepository(appClient = get()) }
}