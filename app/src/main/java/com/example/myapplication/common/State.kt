package com.example.myapplication.common

sealed class State<T> {

     class Loading<T> : State<T>()
     data class Success<T>(val data: T? = null) : State<T>()
     data class Error<T>(val message: String? = null, val exception: Exception? = null) : State<T>()

}