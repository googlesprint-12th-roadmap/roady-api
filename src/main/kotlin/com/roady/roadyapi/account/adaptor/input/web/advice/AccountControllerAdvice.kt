package com.roady.roadyapi.account.adaptor.input.web.advice

import com.roady.roadyapi.account.adaptor.input.web.controller.AccountController
import com.roady.roadyapi.account.domain.IdAlreadyExistsException
import com.roady.roadyapi.account.domain.UnknownIdException
import com.roady.roadyapi.account.domain.WrongPasswordException
import com.roady.roadyapi.account.domain.WrongTokenException
import com.roady.roadyapi.global.domain.ErrorResponse
import com.roady.roadyapi.global.domain.ErrorStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [AccountController::class])
class AccountControllerAdvice {
    @ExceptionHandler(IdAlreadyExistsException::class)
    fun handle(e: IdAlreadyExistsException): ResponseEntity<ErrorResponse> =
        ResponseEntity.badRequest().body(
            ErrorResponse(
                ErrorStatus.ID_ALREADY_EXISTS,
                "이미 존재하는 ID입니다!",
                e.localizedMessage))

    @ExceptionHandler(UnknownIdException::class)
    fun handle(e: UnknownIdException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                ErrorStatus.UNKNOWN_ID,
                "존재하지 않는 ID입니다!",
                e.localizedMessage))

    @ExceptionHandler(WrongPasswordException::class)
    fun handle(e: WrongPasswordException): ResponseEntity<ErrorResponse> =
        ResponseEntity.badRequest().body(
            ErrorResponse(
                ErrorStatus.WRONG_PASSWORD,
                "잘못된 비밀번호입니다!",
                e.localizedMessage))

    @ExceptionHandler(WrongTokenException::class)
    fun handle(e: WrongTokenException): ResponseEntity<ErrorResponse> =
        ResponseEntity.badRequest().body(
            ErrorResponse(
                ErrorStatus.WRONG_TOKEN,
                "잘못된 토큰입니다!",
                e.localizedMessage))

}