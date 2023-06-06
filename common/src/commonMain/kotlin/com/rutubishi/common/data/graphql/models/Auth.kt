package com.rutubishi.common.data.graphql.models

import com.rutubishi.common.data.network.ResponseStatus

data class AuthOutput(
    val token: String?
)

data class AuthResponse(
    val status: ResponseStatus = ResponseStatus.SUCCESS,
    val message: String? = null,
    val data: AuthOutput? = null
)

data class SignInInput(
    val email: String,
    val password: String
)

data class SignUpInput(
    val email: String,
    val fullName: String,
    val phone: String,
    val password: String
)

data class TestOutput(
    val message: String
)