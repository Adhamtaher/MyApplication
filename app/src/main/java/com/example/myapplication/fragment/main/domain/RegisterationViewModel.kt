package com.example.myapplication.fragment.main.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.State
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegisterationViewModel : ViewModel() {

    private val _registrationSharedFlow = MutableSharedFlow<State<RegisterationRespone>>()
    val registrationSharedFlow: SharedFlow<State<RegisterationRespone>> = _registrationSharedFlow

    fun registerUser(userInfo: UserInfo) {
        viewModelScope.launch {
            if (!userInfo.password.contentEquals(userInfo.passwordConfirmation, false)) {
                _registrationSharedFlow.emit(State.Error("Password doesn't match"))
            } else if (userInfo.fullName.isEmpty()
                && userInfo.email.isEmpty()
                && userInfo.password.isEmpty()
                && userInfo.passwordConfirmation.isEmpty()
                && userInfo.city.isEmpty()
                && userInfo.address.isEmpty()
                && userInfo.birthDay.isEmpty()
                && userInfo.phone.isEmpty()
            ) {
                _registrationSharedFlow.emit(State.Error("Please fill the required fields"))
            } else {
                _registrationSharedFlow.emit(State.Loading())
                RegistrationRepository().registerUser(userInfo).collect{
                    _registrationSharedFlow.emit(it)
                }
            }

        }

    }
}