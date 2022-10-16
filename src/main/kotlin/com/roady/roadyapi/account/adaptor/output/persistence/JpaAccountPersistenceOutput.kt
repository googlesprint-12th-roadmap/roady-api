package com.roady.roadyapi.account.adaptor.output.persistence

import com.roady.roadyapi.account.adaptor.output.persistence.extension.toDomain
import com.roady.roadyapi.account.adaptor.output.persistence.extension.toEntity
import com.roady.roadyapi.account.adaptor.output.persistence.repository.AccountRepository
import com.roady.roadyapi.account.application.port.output.persistence.AccountPersistenceOutput
import com.roady.roadyapi.account.domain.Account
import org.springframework.stereotype.Component

@Component
class JpaAccountPersistenceOutput(
    private val accountRepository: AccountRepository
): AccountPersistenceOutput {
    override fun save(domain: Account): Account {
        val entity = domain.toEntity()
        val result = accountRepository.save(entity)
        return result.toDomain()
    }

    override fun existsById(id: String): Boolean =
        accountRepository.existsById(id)

    override fun findById(id: String): Account =
        accountRepository.findById(id).toDomain()
}