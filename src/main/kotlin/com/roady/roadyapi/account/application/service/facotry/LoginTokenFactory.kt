package com.roady.roadyapi.account.application.service.facotry

import com.roady.roadyapi.account.domain.Account
import com.roady.roadyapi.account.domain.LoginToken
import org.springframework.stereotype.Component

@Component
class LoginTokenFactory{
    fun of(account: Account): LoginToken {
        val key = account.idx
        val accessToken = generateAccessToken(key)
        val refreshToken = generateRefreshToken(key)
        return LoginToken(accessToken, refreshToken)
    }

    private fun generateAccessToken(key: Long): String = "$ACCESS_TOKEN_PREFIX$key"
    private fun generateRefreshToken(key: Long): String = "$REFRESH_TOKEN_PREFIX$key"

    companion object {
        const val ACCESS_TOKEN_PREFIX = "access*token&"
        const val REFRESH_TOKEN_PREFIX = "refresh*token&"
    }
}
