package com.roady.roadyapi.account.application.service

import com.roady.roadyapi.account.application.port.input.AccountUseCase
import com.roady.roadyapi.account.application.port.output.PasswordEncodeOutput
import com.roady.roadyapi.account.application.port.output.persistence.AccountPersistenceOutput
import com.roady.roadyapi.account.application.service.facotry.AccountFactory
import com.roady.roadyapi.account.application.service.facotry.LoginTokenFactory
import com.roady.roadyapi.account.domain.*
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountPersistenceOutput: AccountPersistenceOutput,
    private val passwordEncodeOutput: PasswordEncodeOutput,
    private val accountFactory: AccountFactory,
    private val loginTokenFactory: LoginTokenFactory
): AccountUseCase {
    override fun register(register: Register): Long {
        validate(register)

        val encodedPassword = passwordEncodeOutput.encode(register.password)
        val domain = accountFactory.of(register, encodedPassword)

        val account = accountPersistenceOutput.save(domain)
        return account.idx
    }

    override fun login(login: Login): LoginToken {
        validate(login)

        val account = accountPersistenceOutput.findById(login.id)
        return loginTokenFactory.of(account)
    }

    private fun validate(register: Register) {
        if(accountPersistenceOutput.existsById(register.id)) throw IdAlreadyExistsException("이미 해당 ID로 가입한 사용자가 존재합니다!", register.id)
    }

    private fun validate(login: Login) {
        if(!accountPersistenceOutput.existsById(login.id)) throw UnknownIdException("해당 ID를 가진 계정이 존재하지 않습니다!", login.id)
        val account = accountPersistenceOutput.findById(login.id)
        val isMatched = passwordEncodeOutput.matches(login.rawPassword, account.encodedPassword)
        if(!isMatched) throw WrongPasswordException("잘못된 비밀번호입니다!")
    }
}