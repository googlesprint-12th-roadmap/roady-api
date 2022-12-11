package com.roady.roadyapi.account.application.service

import com.roady.roadyapi.account.application.port.input.AccountQueryUseCase
import com.roady.roadyapi.account.application.service.facotry.AccountFactory
import com.roady.roadyapi.account.domain.Account
import org.springframework.stereotype.Service

@Service
class AccountQueryService(
    private val accountFactory: AccountFactory
): AccountQueryUseCase {
    override fun findByAccessToken(token: String): Account =
        accountFactory.of(token)
}