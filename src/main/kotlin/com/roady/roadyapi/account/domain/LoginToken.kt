package com.roady.roadyapi.account.domain

data class LoginToken(
    val accessToken: String,
    val refreshToken: String
)