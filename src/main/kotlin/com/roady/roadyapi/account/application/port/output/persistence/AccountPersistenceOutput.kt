package com.roady.roadyapi.account.application.port.output.persistence

import com.roady.roadyapi.account.domain.Account

interface AccountPersistenceOutput {
    fun save(domain: Account): Account
    fun existsById(id: String): Boolean
    fun findById(id: String): Account
}
