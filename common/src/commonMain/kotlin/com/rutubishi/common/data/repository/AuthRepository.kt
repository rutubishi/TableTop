package com.rutubishi.common.data.repository

import com.apollographql.apollo3.ApolloClient
import com.rutubishi.common.data.graphql.models.AuthOutput
import com.rutubishi.common.data.network.LoginUserMutation
import com.rutubishi.common.data.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepository(
    private val appClient: ApolloClient
) : IAuthRepository {

    override fun login(email: String, password: String) = flow {
        emit(Resource.Loading())
        try {
            val response = appClient.mutation(LoginUserMutation(email, password)).execute()
            val data = response.data
            if (data != null) {
                val authOutput = AuthOutput(token = data.signIn.token,)
                emit(Resource.Success(authOutput))
            } else emit(Resource.Error(response.errors?.first()?.message ?: "Unknown error"))
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }

    override fun register(
        email: String,
        password: String,
        fullName: String,
        phone: String
    ): Flow<Resource<AuthOutput>> = flow {
        TODO("Not yet implemented")
    }

}


interface IAuthRepository {
    fun login(email: String, password: String): Flow<Resource<AuthOutput>>
    fun register(email: String, password: String, fullName: String, phone: String): Flow<Resource<AuthOutput>>
}
