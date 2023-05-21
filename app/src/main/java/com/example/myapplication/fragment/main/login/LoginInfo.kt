package com.example.myapplication.fragment.main.login

import com.google.gson.annotations.SerializedName

data class LoginInfo(
    @SerializedName("name")
                     val fullName: String,
                     @SerializedName("password")
                     val password: String
                     )
