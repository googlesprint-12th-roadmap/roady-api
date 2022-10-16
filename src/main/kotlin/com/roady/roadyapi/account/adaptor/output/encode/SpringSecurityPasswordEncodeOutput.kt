package com.roady.roadyapi.account.adaptor.output.encode

import com.roady.roadyapi.account.application.port.output.PasswordEncodeOutput
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class SpringSecurityPasswordEncodeOutput(
    private val passwordEncoder: PasswordEncoder
): PasswordEncodeOutput {
    override fun encode(rawPassword: String): String = passwordEncoder.encode(rawPassword)
    override fun matches(rawPassword: String, encodedPassword: String): Boolean = passwordEncoder.matches(rawPassword, encodedPassword)
}