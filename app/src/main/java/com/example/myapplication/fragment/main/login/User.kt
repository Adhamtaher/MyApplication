package com.example.myapplication.fragment.main.login

data class User(
    val __v: Int,
    val _id: String,
    val confirmedEmail: Boolean,
    val createdAt: String,
    val email: String,
    val files: List<Any>,
    val gender: String,
    val isLoggedIn: Boolean,
    val name: String,
    val notes: List<Any>,
    val password: List<String>,
    val patientInfo: LoginInfo,
    val phone: String,
    val role: String,
    val updatedAt: String
)