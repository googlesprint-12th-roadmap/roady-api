package com.roady.roadyapi.account.application.service

import com.roady.roadyapi.account.application.port.input.AccountUseCase
import com.roady.roadyapi.account.application.port.output.PasswordEncodeOutput
import com.roady.roadyapi.account.application.port.output.persistence.AccountPersistenceOutput
import com.roady.roadyapi.account.application.service.facotry.AccountFactory
import com.roady.roadyapi.account.domain.IdAlreadyExistsException
import com.roady.roadyapi.account.domain.Register
import org.springframework.stereotype.Service

@Service
class AccountService(
    val accountPersistenceOutput: AccountPersistenceOutput,
    val passwordEncodeOutput: PasswordEncodeOutput
): AccountUseCase {
    override fun register(register: Register): Long {
        validate(register)

        val encodedPassword = passwordEncodeOutput.encode(register.password)
        val domain = AccountFactory.of(register, encodedPassword)

        val account = accountPersistenceOutput.save(domain)
        return account.idx
    }

    private fun validate(register: Register) {
        if(accountPersistenceOutput.existsById(register.id)) throw IdAlreadyExistsException("이미 해당 ID로 가입한 사용자가 존재합니다!", register.id)
    }
}