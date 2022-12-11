package com.roady.roadyapi.account.domain

class WrongTokenException(message: String, accessToken: String) : RuntimeException("$message | access token: $accessToken") {
    constructor(message: String, accessToken: String, cause: Throwable) : this(message, accessToken) { initCause(cause) }
}