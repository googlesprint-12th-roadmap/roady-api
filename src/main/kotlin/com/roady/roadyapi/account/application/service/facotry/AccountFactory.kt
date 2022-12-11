package com.roady.roadyapi.account.application.service.facotry

import com.roady.roadyapi.account.domain.Account
import com.roady.roadyapi.account.domain.Register

object AccountFactory {
    fun of(register: Register, encodedPassword: String) = Account(
        nickname = register.nickname,
        id = register.id,
        encodedPassword = encodedPassword
    )
}
