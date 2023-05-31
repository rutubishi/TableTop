package com.rutubishi.common.data.graphql.models

data class AuthOutput(
    val token: String?
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