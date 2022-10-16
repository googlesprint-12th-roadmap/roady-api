package com.roady.roadyapi.roadmap.adaptor.output.persistence

import com.roady.roadyapi.roadmap.adaptor.output.persistence.extension.toDomain
import com.roady.roadyapi.roadmap.adaptor.output.persistence.extension.toEntity
import com.roady.roadyapi.roadmap.adaptor.output.persistence.repository.RoadmapNodeRepository
import com.roady.roadyapi.roadmap.adaptor.output.persistence.repository.RoadmapRepository
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import com.roady.roadyapi.roadmap.domain.Roadmap
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class JpaRoadmapPersistenceOutput(
    private val roadmapRepository: RoadmapRepository,
    private val roadmapNodeRepository: RoadmapNodeRepository
): RoadmapPersistenceOutput {
    override fun existsByIdx(idx: Long): Boolean =
        roadmapRepository.existsByIdx(idx)

    override fun findByIdx(idx: Long): Roadmap {
        val nodes = roadmapNodeRepository.findAllByRoadmapIdx(idx).toSet()
        return roadmapRepository.findByIdx(idx).toDomain(nodes)
    }

    @Transactional
    override fun save(roadmap: Roadmap): Long {
        val entity = roadmapRepository.save(roadmap.toEntity())
        roadmap.nodes.forEach { roadmapNodeRepository.save(it.toEntity(entity.idx)) }
        return entity.idx
    }

    @Transactional
    override fun deleteByIdx(idx: Long) {
        roadmapRepository.deleteAllByIdx(idx)
        roadmapNodeRepository.deleteAllByRoadmapIdx(idx)
    }
}