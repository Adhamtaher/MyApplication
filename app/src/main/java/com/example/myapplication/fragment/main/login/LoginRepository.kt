package com.example.myapplication.fragment.main.login

import android.util.Log
import com.example.myapplication.common.BaseRepository
import com.example.myapplication.common.HospiService
import com.example.myapplication.common.State
import com.example.myapplication.fragment.main.domain.RegisterationRespone
import com.example.myapplication.fragment.main.domain.UserInfo
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class LoginRepository : BaseRepository() {
    fun loginUser(loginInfo: LoginInfo) = flow<State<LoginResponse>> {
        try {
            val reposonse = service.loginUser(loginInfo).body()
            if (reposonse?.message == "Welcome") {
                emit(State.Success())
            } else {
                emit(State.Error(message = reposonse?.message))
            }
        } catch (e: Exception) {
            emit(State.Error(message = e.message))
        }
    }

}