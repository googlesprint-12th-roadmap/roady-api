package com.roady.roadyapi.roadmap.adaptor.output.persistence.repository

import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapNodeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoadmapNodeRepository: JpaRepository<RoadmapNodeEntity, Long> {
    fun findAllByRoadmapIdx(roadmapIdx: Long): List<RoadmapNodeEntity>
}