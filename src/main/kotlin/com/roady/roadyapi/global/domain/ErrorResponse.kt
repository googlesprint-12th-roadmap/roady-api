package com.roady.roadyapi.global.domain

data class ErrorResponse(
    val status: ErrorStatus,
    val message: String,
    val detail: String
)