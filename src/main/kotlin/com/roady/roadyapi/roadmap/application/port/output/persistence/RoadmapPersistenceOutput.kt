package com.roady.roadyapi.roadmap.application.port.output.persistence

interface RoadmapPersistenceOutput {
    fun create(name: String, ownerIdx: Long): Long
}
