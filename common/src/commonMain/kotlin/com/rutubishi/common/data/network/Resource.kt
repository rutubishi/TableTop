package com.rutubishi.common.data.network

sealed class Resource <T> (val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Idle<T>(data: T? = null): Resource<T>(data)
}

data class AppResponse<T>(
    val data: T? = null,
    val message: String? = null,
    val status: ResponseStatus = ResponseStatus.SUCCESS
)

enum class ResponseStatus {
    SUCCESS, ERROR
}