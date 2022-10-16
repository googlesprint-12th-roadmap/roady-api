package com.roady.roadyapi.roadmap.adaptor.input.web.data.response

import com.roady.roadyapi.roadmap.domain.RoadmapNode

data class RoadmapQueryResponse(
    val idx: Long,
    val ownerIdx: Long,
    val rootIdx: Long,
    val name: String,
    val nodes: Set<RoadmapNode>,
    val canEdit: Boolean
)