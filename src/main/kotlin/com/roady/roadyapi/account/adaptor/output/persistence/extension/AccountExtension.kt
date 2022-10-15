package com.roady.roadyapi.account.adaptor.output.persistence.extension

import com.roady.roadyapi.account.adaptor.output.persistence.data.entity.AccountEntity
import com.roady.roadyapi.account.domain.Account

fun AccountEntity.toDomain(): Account =
    Account(
        idx = idx,
        nickname = nickname,
        id = id,
        encodedPassword = encodedPassword
    )

fun Account.toEntity(): AccountEntity =
    AccountEntity(
        idx = idx,
        nickname = nickname,
        id = id,
        encodedPassword = encodedPassword
    )