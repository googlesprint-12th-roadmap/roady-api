package com.roady.roadyapi.roadmap.adaptor.input.web.controller

import com.roady.roadyapi.account.application.port.input.AccountQueryUseCase
import com.roady.roadyapi.roadmap.adaptor.input.web.data.request.CreateRoadmapRequest
import com.roady.roadyapi.roadmap.adaptor.input.web.data.response.CreateRoadmapResponse
import com.roady.roadyapi.roadmap.adaptor.input.web.extension.toDomain
import com.roady.roadyapi.roadmap.adaptor.input.web.property.RoadmapProperty
import com.roady.roadyapi.roadmap.application.port.input.RoadmapUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/roadmap")
class RoadmapController(
    private val roadmapProperty: RoadmapProperty,
    private val roadmapUseCase: RoadmapUseCase,
    private val accountQueryUseCase: AccountQueryUseCase
) {
    @PostMapping
    fun createRoadmap(@RequestHeader("Authorization") token: String,
                      @RequestBody request: CreateRoadmapRequest
    ): ResponseEntity<CreateRoadmapResponse> {
        val accountIdx = accountQueryUseCase.findByAccessToken(token).idx
        val domain = request.toDomain(accountIdx)

        val roadmapId = roadmapUseCase.createRoadmap(domain)

        val response = CreateRoadmapResponse(roadmapId)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/guest")
    fun createRoadmap(@RequestBody request: CreateRoadmapRequest): ResponseEntity<CreateRoadmapResponse> {
        val accountIdx = roadmapProperty.guestAccountIdx
        val domain = request.toDomain(accountIdx)

        val roadmapId = roadmapUseCase.createRoadmap(domain)

        val response = CreateRoadmapResponse(roadmapId)
        return ResponseEntity.ok(response)
    }
}