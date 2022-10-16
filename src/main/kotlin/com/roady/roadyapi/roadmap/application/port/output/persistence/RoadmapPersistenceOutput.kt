package com.roady.roadyapi.roadmap.application.port.output.persistence

import com.roady.roadyapi.roadmap.domain.Roadmap

interface RoadmapPersistenceOutput {
    fun create(name: String, ownerIdx: Long, rootIdx: Long): Long
    fun existsByIdx(idx: Long): Boolean
    fun findById(idx: Long): Roadmap
    fun save(roadmap: Roadmap): Long
    fun deleteById(idx: Long)
}
