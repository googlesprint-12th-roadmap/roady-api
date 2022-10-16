package com.roady.roadyapi.roadmap.adaptor.output.persistence

import com.roady.roadyapi.roadmap.adaptor.output.persistence.extension.toEntity
import com.roady.roadyapi.roadmap.adaptor.output.persistence.repository.RoadmapNodeRepository
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapNodePersistenceOutput
import com.roady.roadyapi.roadmap.domain.RoadmapNode
import org.springframework.stereotype.Component

@Component
class JpaRoadmapNodePersistenceOutput(
    private val roadmapNodeRepository: RoadmapNodeRepository
): RoadmapNodePersistenceOutput {
    override fun saveAll(roadmapIdx: Long, nodes: List<RoadmapNode>) {
        val entities = nodes.map { it.toEntity(roadmapIdx) }
        roadmapNodeRepository.saveAll(entities)
    }
}