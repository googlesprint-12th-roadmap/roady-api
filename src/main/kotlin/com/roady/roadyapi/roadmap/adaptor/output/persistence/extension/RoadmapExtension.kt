package com.roady.roadyapi.roadmap.adaptor.output.persistence.extension

import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapEntity
import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapNodeEntity
import com.roady.roadyapi.roadmap.domain.Roadmap
import com.roady.roadyapi.roadmap.domain.RoadmapNode

fun RoadmapNode.toEntity(roadmapIdx: Long): RoadmapNodeEntity =
    RoadmapNodeEntity(
        idx = idx,
        roadmapIdx = roadmapIdx,
        title = title,
        desc = desc,
        url = url,
        type = type,
        children = children,
        parent = parent
    )

fun RoadmapEntity.toDomain(nodes: Set<RoadmapNodeEntity>) = Roadmap(
    idx = idx,
    name = name,
    ownerIdx = ownerIdx,
    rootIdx = rootIdx,
    nodes = nodes.map(RoadmapNodeEntity::toDomain).toSet()
)

fun Roadmap.toEntity() = RoadmapEntity(
    idx = idx,
    name = name,
    ownerIdx = ownerIdx,
    rootIdx = rootIdx
)

fun RoadmapNodeEntity.toDomain() = RoadmapNode(
    idx = idx,
    title = title,
    desc = desc,
    url = url,
    type = type,
    children = children,
    parent = parent
)