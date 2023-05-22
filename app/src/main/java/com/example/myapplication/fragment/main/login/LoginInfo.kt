package com.example.myapplication.fragment.main.login

import com.google.gson.annotations.SerializedName

data class LoginInfo(
    @SerializedName("email")
                     val fullName: String,
                     @SerializedName("password")
                     val password: String

                     )
