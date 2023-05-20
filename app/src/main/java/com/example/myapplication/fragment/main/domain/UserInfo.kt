package com.example.myapplication.fragment.main.domain

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("name")
    val fullName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("cPassword")
    val passwordConfirmation: String,
    @Transient // TODO replace transient with @SerializedName once back end implemented the field
    val city: String,
    @Transient
    val address: String,
    @Transient
    val birthDay: String,
    @Transient
    val phone: String,
    @SerializedName("role")
    val role: String = "patient",
    @SerializedName("gender")
    val gender: String = "male",
)