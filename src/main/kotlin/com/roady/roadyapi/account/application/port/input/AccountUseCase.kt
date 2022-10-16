package com.roady.roadyapi.account.application.port.input

import com.roady.roadyapi.account.domain.Register

interface AccountUseCase {
    fun register(register: Register): Long
}
