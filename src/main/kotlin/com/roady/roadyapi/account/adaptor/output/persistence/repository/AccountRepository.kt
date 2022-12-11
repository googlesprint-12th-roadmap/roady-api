package com.roady.roadyapi.account.adaptor.output.persistence.repository

import com.roady.roadyapi.account.adaptor.output.persistence.data.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<AccountEntity, Long> {
    fun existsById(id: String): Boolean
}