package com.roady.roadyapi.account.adaptor.input.web.controller

import com.roady.roadyapi.account.adaptor.input.web.data.request.RegisterRequest
import com.roady.roadyapi.account.adaptor.input.web.data.response.RegisterResponse
import com.roady.roadyapi.account.adaptor.input.web.extension.toDomain
import com.roady.roadyapi.account.application.port.input.AccountUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/account")
class AccountController(
    val accountUseCase: AccountUseCase
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<RegisterResponse> {
        val domain = request.toDomain()
        val accountIdx = accountUseCase.register(domain)
        val response = RegisterResponse(accountIdx)
        return ResponseEntity.ok(response)
    }
}