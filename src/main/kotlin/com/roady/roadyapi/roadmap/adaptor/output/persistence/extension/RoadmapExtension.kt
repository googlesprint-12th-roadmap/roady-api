package com.roady.roadyapi.roadmap.adaptor.output.persistence.extension

import com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity.RoadmapNodeEntity
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