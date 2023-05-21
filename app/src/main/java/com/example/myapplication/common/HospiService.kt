package com.example.myapplication.common

import com.example.myapplication.fragment.main.domain.RegisterationRespone
import com.example.myapplication.fragment.main.domain.UserInfo
import com.example.myapplication.fragment.main.login.LoginInfo
import com.example.myapplication.fragment.main.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface HospiService {

    @POST("/api/v1//signUp")
    suspend fun registerUser(@Body userInfo: UserInfo): Response<RegisterationRespone>
    @POST("/api/v1//signIn")
    suspend fun loginUser(@Body loginInfo: LoginInfo): Response<LoginResponse>
    //@GET("/api/v1//")
    //suspend fun

}