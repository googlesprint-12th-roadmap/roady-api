package com.roady.roadyapi.roadmap.application.service

import com.roady.roadyapi.global.domain.UnknownIdxException
import com.roady.roadyapi.roadmap.application.port.input.RoadmapQueryUseCase
import com.roady.roadyapi.roadmap.application.port.output.persistence.RoadmapPersistenceOutput
import com.roady.roadyapi.roadmap.domain.Roadmap
import org.springframework.stereotype.Service

@Service
class RoadmapQueryService(
    private val roadmapPersistenceOutput: RoadmapPersistenceOutput
): RoadmapQueryUseCase {
    override fun findById(idx: Long): Roadmap {
        if(!roadmapPersistenceOutput.existsByIdx(idx)) throw UnknownIdxException("해당 Idx를 가진 로드맵이 존재하지 않습니다!", idx)

        return roadmapPersistenceOutput.findByIdx(idx)
    }

    override fun canEdit(idx: Long, accountIdx: Long): Boolean {
        if(!roadmapPersistenceOutput.existsByIdx(idx)) throw UnknownIdxException("해당 Idx를 가진 로드맵이 존재하지 않습니다!", idx)

        val roadmap = roadmapPersistenceOutput.findByIdx(idx)
        return roadmap.ownerIdx == accountIdx
    }
}