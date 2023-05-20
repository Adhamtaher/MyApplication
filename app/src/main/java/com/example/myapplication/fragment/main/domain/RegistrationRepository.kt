package com.example.myapplication.fragment.main.domain

import com.example.myapplication.common.BaseRepository
import com.example.myapplication.common.State
import kotlinx.coroutines.flow.flow

class RegistrationRepository : BaseRepository() {

    fun registerUser(userInfo: UserInfo) = flow<State<RegisterationRespone>> {
        try {
            val reposonse = service.registerUser(userInfo).body()
            if (reposonse?.message == "patient added") {
                emit(State.Success())
            } else {
                emit(State.Error(message = reposonse?.message))
            }
        } catch (e: Exception) {
            emit(State.Error(message = e.message))
        }
    }
}