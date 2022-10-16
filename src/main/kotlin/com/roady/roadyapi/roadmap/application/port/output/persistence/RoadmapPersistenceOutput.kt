package com.roady.roadyapi.roadmap.application.port.output.persistence

import com.roady.roadyapi.roadmap.domain.Roadmap

interface RoadmapPersistenceOutput {
    fun existsByIdx(idx: Long): Boolean
    fun findByIdx(idx: Long): Roadmap
    fun save(roadmap: Roadmap): Long
    fun deleteByIdx(idx: Long)
}
