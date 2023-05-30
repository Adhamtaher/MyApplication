package com.example.myapplication.fragment.main.login

import android.media.session.MediaSession
import android.util.JsonToken
import androidx.annotation.Keep
import com.example.myapplication.fragment.main.domain.Added
import com.google.gson.annotations.SerializedName

@Keep
data class LoginResponse (
    @SerializedName("message")
    val message: String?,
    @SerializedName("token")
    val token: JsonToken
        )