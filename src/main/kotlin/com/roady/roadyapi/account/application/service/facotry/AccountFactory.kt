package com.roady.roadyapi.account.application.service.facotry

import com.roady.roadyapi.account.adaptor.output.persistence.extension.toDomain
import com.roady.roadyapi.account.adaptor.output.persistence.repository.AccountRepository
import com.roady.roadyapi.account.domain.Account
import com.roady.roadyapi.account.domain.Register
import com.roady.roadyapi.account.domain.UnknownIdxException
import com.roady.roadyapi.account.domain.WrongTokenException
import org.springframework.stereotype.Component

@Component
class AccountFactory(
    private val accountRepository: AccountRepository
) {
    fun of(register: Register, encodedPassword: String) = Account(
        nickname = register.nickname,
        id = register.id,
        encodedPassword = encodedPassword
    )

    fun of(accessToken: String): Account {
        val accountIdx: Long
        try { accountIdx = accessToken.removePrefix(LoginTokenFactory.ACCESS_TOKEN_PREFIX).toLong() }
        catch (e: NumberFormatException) { throw WrongTokenException("잘못된 토큰입니다!", accessToken) }

        return accountRepository.findById(accountIdx)
            .orElseThrow { WrongTokenException("잘못된 토큰입니다!", accessToken, UnknownIdxException("해당 Idx를 가진 계정이 존재하지 않습니다!", accountIdx)) }
            .toDomain()
    }
}
