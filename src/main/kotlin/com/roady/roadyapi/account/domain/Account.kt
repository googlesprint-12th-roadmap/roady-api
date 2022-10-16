package com.roady.roadyapi.account.domain

data class Account(
    val idx: Long = 0,
    val nickname: String,
    val id: String,
    val encodedPassword: String
)