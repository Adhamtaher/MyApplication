package com.example.myapplication.fragment.main.domain


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Added(
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: List<String?>?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("confirmedEmail")
    val confirmedEmail: Boolean?,
    @SerializedName("isLoggedIn")
    val isLoggedIn: Boolean?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("__v")
    val v: Int?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)