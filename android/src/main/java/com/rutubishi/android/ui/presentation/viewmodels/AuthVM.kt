package com.rutubishi.android.ui.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rutubishi.common.data.graphql.models.AuthOutput
import com.rutubishi.common.data.network.Resource
import com.rutubishi.common.data.repository.IAuthRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AuthVM(
    private val repository: IAuthRepository
) : ViewModel() {

    private val _authState: MutableState<Resource<AuthOutput?>> =
        mutableStateOf(Resource.Success(null))
    val authState: MutableState<Resource<AuthOutput?>> = _authState

    fun login(
        email: String,
        password: String){
        repository
            .login(email, password)
            .onEach(::wrapState)
            .launchIn(viewModelScope)
    }

    fun register(
        name: String,
        email: String,
        password: String,
        phone: String){
        repository
            .register(email, password, name, phone)
            .onEach(::wrapState)
            .launchIn(viewModelScope)
    }

    private fun wrapState(state: Resource<AuthOutput>) {
        when(state) {
            is Resource.Loading -> {
                _authState.value = Resource.Loading()
            }
            is Resource.Success -> {
                _authState.value = Resource.Success(state.data)
            }
            is Resource.Error -> {
                _authState.value = Resource.Error(state.message!!)
            }
        }
    }

}