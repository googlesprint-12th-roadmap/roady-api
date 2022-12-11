package com.roady.roadyapi.account.adaptor.input.web.data.request

data class RegisterRequest(
    val nickname: String,
    val id: String,
    val password: String
)