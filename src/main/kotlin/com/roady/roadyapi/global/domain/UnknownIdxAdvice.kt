package com.roady.roadyapi.global.domain

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class UnknownIdxAdvice {
    @ExceptionHandler(UnknownIdxException::class)
    fun handle(e: UnknownIdxException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                ErrorStatus.UNKNOWN_IDX,
                "존재하지 않는 Index입니다!",
                e.localizedMessage))
}