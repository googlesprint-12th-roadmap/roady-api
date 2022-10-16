package com.roady.roadyapi.roadmap.application.service

import com.roady.roadyapi.roadmap.application.port.input.RoadmapUseCase
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapNodePersistenceOutput
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import com.roady.roadyapi.roadmap.domain.CreateRoadmap
import org.springframework.stereotype.Service

@Service
class RoadmapService(
    private val roadmapPersistenceOutput: RoadmapPersistenceOutput,
    private val roadmapNodePersistenceOutput: RoadmapNodePersistenceOutput
): RoadmapUseCase {
    override fun createRoadmap(create: CreateRoadmap): Long {
        val roadmapIdx = roadmapPersistenceOutput.create(create.name, create.ownerIdx)
        roadmapNodePersistenceOutput.saveAll(roadmapIdx, create.nodes)
        return roadmapIdx
    }
}