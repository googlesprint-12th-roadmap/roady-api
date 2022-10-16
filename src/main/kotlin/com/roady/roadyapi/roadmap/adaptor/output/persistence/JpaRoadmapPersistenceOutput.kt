package com.roady.roadyapi.roadmap.adaptor.output.persistence

import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapEntity
import com.roady.roadyapi.roadmap.adaptor.output.persistence.repository.RoadmapRepository
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import org.springframework.stereotype.Component

@Component
class JpaRoadmapPersistenceOutput(
    private val roadmapRepository: RoadmapRepository
): RoadmapPersistenceOutput {
    override fun create(name: String, ownerIdx: Long): Long {
        val entity = RoadmapEntity(name = name, ownerIdx = ownerIdx)
        return roadmapRepository.save(entity).idx
    }
}