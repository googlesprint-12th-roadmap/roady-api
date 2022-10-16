package com.roady.roadyapi.roadmap.adaptor.input.web.controller

import com.roady.roadyapi.account.application.port.input.AccountQueryUseCase
import com.roady.roadyapi.roadmap.adaptor.input.web.data.request.CreateRoadmapRequest
import com.roady.roadyapi.roadmap.adaptor.input.web.data.request.EditRoadmapRequest
import com.roady.roadyapi.roadmap.adaptor.input.web.data.response.CreateRoadmapResponse
import com.roady.roadyapi.roadmap.adaptor.input.web.data.response.EditRoadmapResponse
import com.roady.roadyapi.roadmap.adaptor.input.web.data.response.RoadmapQueryResponse
import com.roady.roadyapi.roadmap.adaptor.input.web.extension.toDomain
import com.roady.roadyapi.roadmap.adaptor.input.web.property.RoadmapProperty
import com.roady.roadyapi.roadmap.application.port.input.RoadmapQueryUseCase
import com.roady.roadyapi.roadmap.application.port.input.RoadmapUseCase
import com.roady.roadyapi.roadmap.domain.DeleteRoadmap
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
@RequestMapping("/api/v1/roadmap")
class RoadmapController(
    private val roadmapProperty: RoadmapProperty,
    private val roadmapUseCase: RoadmapUseCase,
    private val roadmapQueryUseCase: RoadmapQueryUseCase,
    private val accountQueryUseCase: AccountQueryUseCase
) {
    @PostMapping
    fun createRoadmap(@RequestHeader("Authorization") token: String,
                      @RequestBody request: CreateRoadmapRequest
    ): ResponseEntity<CreateRoadmapResponse> {
        val accountIdx = accountQueryUseCase.findByAccessToken(token).idx
        val domain = request.toDomain(accountIdx)

        val roadmapIdx = roadmapUseCase.createRoadmap(domain)

        val response = CreateRoadmapResponse(roadmapIdx)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/guest")
    fun createRoadmap(@RequestBody request: CreateRoadmapRequest): ResponseEntity<CreateRoadmapResponse> {
        val accountIdx = roadmapProperty.guestAccountIdx
        val domain = request.toDomain(accountIdx)

        val roadmapIdx = roadmapUseCase.createRoadmap(domain)

        val response = CreateRoadmapResponse(roadmapIdx)
        return ResponseEntity.ok(response)
    }
    @PutMapping("/{idx}")
    fun editRoadmap(@PathVariable idx: Long,
                    @RequestHeader("Authorization") token: String,
                    @RequestBody request: EditRoadmapRequest
    ): ResponseEntity<EditRoadmapResponse> {
        val accountIdx = accountQueryUseCase.findByAccessToken(token).idx
        val domain = request.toDomain(idx, accountIdx)

        val roadmapIdx = roadmapUseCase.editRoadmap(domain)

        val response = EditRoadmapResponse(roadmapIdx)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{idx}")
    fun deleteRoadmap(@PathVariable idx: Long,
                      @RequestHeader("Authorization") token: String
    ): ResponseEntity<Unit> {
        val accountIdx = accountQueryUseCase.findByAccessToken(token).idx
        val domain = DeleteRoadmap(idx, accountIdx)

        roadmapUseCase.deleteRoadmap(domain)

        return ResponseEntity.ok().build()
    }

    @GetMapping("/query/{idx}")
    fun queryRoadmapById(@PathVariable idx: Long,
                         @RequestHeader("Authorization") token: String?
    ): ResponseEntity<RoadmapQueryResponse> {
        val canEdit = token?.let {
                val accountIdx = accountQueryUseCase.findByAccessToken(token).idx
                roadmapQueryUseCase.canEdit(idx, accountIdx)
            }?: false

        val roadmap = roadmapQueryUseCase.findById(idx)

        val response = RoadmapQueryResponse(roadmap.idx, roadmap.ownerIdx, roadmap.rootIdx, roadmap.name, roadmap.nodes, canEdit)
        return ResponseEntity.ok(response)
    }
}