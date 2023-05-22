package com.example.myapplication.fragment.main.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.State
import com.example.myapplication.fragment.main.domain.RegisterationRespone
import com.example.myapplication.fragment.main.domain.RegistrationRepository
import com.example.myapplication.fragment.main.domain.UserInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel :ViewModel(){
    private val _loginSharedFlow = MutableSharedFlow<State<LoginResponse>>()
    val loginSharedFlow: SharedFlow<State<LoginResponse>> = _loginSharedFlow

    fun loginUser(loginInfo: LoginInfo) {
        viewModelScope.launch {
            if (loginInfo.fullName.isEmpty()
                && loginInfo.password.isEmpty()) {
                _loginSharedFlow.emit(State.Error("Please fill the required fields"))
            }
            else {
                _loginSharedFlow    .emit(State.Loading())
                LoginRepository().loginUser(loginInfo).collect{
                    _loginSharedFlow.emit(it)
                }
            }

        }

    }
}
