package com.roady.roadyapi.roadmap.application.service

import com.roady.roadyapi.roadmap.application.port.input.RoadmapQueryUseCase
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import com.roady.roadyapi.roadmap.domain.Roadmap
import org.springframework.stereotype.Service

@Service
class RoadmapQueryService(
    private val roadmapPersistenceOutput: RoadmapPersistenceOutput
): RoadmapQueryUseCase {
    override fun findById(idx: Long): Roadmap =
        roadmapPersistenceOutput.findById(idx)
}