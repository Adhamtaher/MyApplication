package com.example.myapplication.fragment.main.domain


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RegisterationRespone(
    @SerializedName("message")
    val message: String?,
    @SerializedName("added")
    val added: List<Added?>?
)