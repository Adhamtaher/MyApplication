package com.example.myapplication.fragment.main.login

import androidx.annotation.Keep
import com.example.myapplication.fragment.main.domain.Added
import com.google.gson.annotations.SerializedName

@Keep
data class LoginResponse (
    @SerializedName("message")
    val message: String?,
    @SerializedName("added")
    val LoginAdded: List<LoginAdded?>?
        )