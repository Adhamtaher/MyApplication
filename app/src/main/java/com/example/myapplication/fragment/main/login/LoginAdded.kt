package com.example.myapplication.fragment.main.login

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LoginAdded(
    @SerializedName("message")
    val message: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: User
)