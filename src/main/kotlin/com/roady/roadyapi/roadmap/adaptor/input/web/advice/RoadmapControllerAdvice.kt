package com.roady.roadyapi.roadmap.adaptor.input.web.advice

import com.roady.roadyapi.global.domain.ErrorResponse
import com.roady.roadyapi.global.domain.ErrorStatus
import com.roady.roadyapi.roadmap.adaptor.input.web.controller.RoadmapController
import com.roady.roadyapi.roadmap.domain.EmptyArgumentException
import com.roady.roadyapi.roadmap.domain.PermissionDeniedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [RoadmapController::class])
class RoadmapControllerAdvice {

    @ExceptionHandler(EmptyArgumentException::class)
    fun handle(e: EmptyArgumentException): ResponseEntity<ErrorResponse> =
        ResponseEntity.badRequest().body(
            ErrorResponse(
                ErrorStatus.EMPTY_ARGUMENT,
                "인자값이 비어있습니다!",
                e.localizedMessage)
        )

    @ExceptionHandler(PermissionDeniedException::class)
    fun handle(e: PermissionDeniedException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.FORBIDDEN).body(
            ErrorResponse(
                ErrorStatus.PERMISSION_DENIED,
                "권한이 없습니다!!",
                e.localizedMessage))
}