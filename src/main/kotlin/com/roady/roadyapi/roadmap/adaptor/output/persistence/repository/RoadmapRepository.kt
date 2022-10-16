package com.roady.roadyapi.roadmap.adaptor.output.persistence.repository

import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoadmapRepository: JpaRepository<RoadmapEntity, Long> {
    fun existsByIdx(idx: Long): Boolean
    fun findByIdx(idx: Long): RoadmapEntity
}