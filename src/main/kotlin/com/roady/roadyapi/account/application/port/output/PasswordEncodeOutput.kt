package com.roady.roadyapi.account.application.port.output

interface PasswordEncodeOutput {
    fun encode(rawPassword: String): String
}
