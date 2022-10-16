package com.roady.roadyapi.roadmap.adaptor.output.persistence

import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapEntity
import com.roady.roadyapi.roadmap.adaptor.output.persistence.extension.toDomain
import com.roady.roadyapi.roadmap.adaptor.output.persistence.extension.toEntity
import com.roady.roadyapi.roadmap.adaptor.output.persistence.repository.RoadmapNodeRepository
import com.roady.roadyapi.roadmap.adaptor.output.persistence.repository.RoadmapRepository
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import com.roady.roadyapi.roadmap.domain.Roadmap
import org.springframework.stereotype.Component

@Component
class JpaRoadmapPersistenceOutput(
    private val roadmapRepository: RoadmapRepository,
    private val roadmapNodeRepository: RoadmapNodeRepository
): RoadmapPersistenceOutput {
    override fun create(name: String, ownerIdx: Long, rootIdx: Long): Long {
        val entity = RoadmapEntity(name = name, ownerIdx = ownerIdx, rootIdx = rootIdx)
        return roadmapRepository.save(entity).idx
    }

    override fun existsByIdx(idx: Long): Boolean =
        roadmapRepository.existsByIdx(idx)

    override fun findById(idx: Long): Roadmap {
        val nodes = roadmapNodeRepository.findAllByRoadmapIdx(idx).toSet()
        return roadmapRepository.findByIdx(idx).toDomain(nodes)
    }

    override fun save(roadmap: Roadmap): Long {
        val entity = roadmapRepository.save(roadmap.toEntity())
        roadmap.nodes.forEach { roadmapNodeRepository.save(it.toEntity(entity.idx)) }
        return entity.idx
    }

    override fun deleteById(idx: Long) {
        roadmapRepository.deleteById(idx)
        roadmapNodeRepository.deleteAllByRoadmapIdx(idx)
    }
}