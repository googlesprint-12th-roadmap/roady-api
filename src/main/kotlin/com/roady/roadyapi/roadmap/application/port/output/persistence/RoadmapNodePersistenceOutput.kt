package com.roady.roadyapi.roadmap.application.port.output.persistence

import com.roady.roadyapi.roadmap.domain.RoadmapNode

interface RoadmapNodePersistenceOutput {
    fun saveAll(roadmapIdx: Long, nodes: List<RoadmapNode>)
}
