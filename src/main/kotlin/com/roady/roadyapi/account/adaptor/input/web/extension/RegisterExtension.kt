package com.roady.roadyapi.account.adaptor.input.web.extension

import com.roady.roadyapi.account.adaptor.input.web.data.request.RegisterRequest
import com.roady.roadyapi.account.domain.Register

fun RegisterRequest.toDomain() = Register(
    nickname = nickname,
    id = id,
    password = password
)