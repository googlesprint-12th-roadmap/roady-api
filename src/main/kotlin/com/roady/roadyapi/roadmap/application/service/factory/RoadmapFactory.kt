package com.roady.roadyapi.roadmap.application.service.factory

import com.roady.roadyapi.roadmap.domain.CreateRoadmap
import com.roady.roadyapi.roadmap.domain.EditRoadmap
import com.roady.roadyapi.roadmap.domain.Roadmap
import org.springframework.stereotype.Component

@Component
class RoadmapFactory {
    fun of(roadmap: Roadmap, edit: EditRoadmap) =
        roadmap.copy(
            name = edit.name ?: roadmap.name,
            nodes = edit.nodes ?: roadmap.nodes
        )

    fun of(roadmap: CreateRoadmap) = Roadmap(
        name = roadmap.name,
        ownerIdx = roadmap.ownerIdx,
        rootIdx = roadmap.rootIdx,
        nodes = emptySet()
    )
}
