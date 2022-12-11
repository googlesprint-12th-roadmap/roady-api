package com.roady.roadyapi.account.application.port.input

import com.roady.roadyapi.account.domain.Account

interface AccountQueryUseCase {
    fun findByAccessToken(token: String): Account
}
