package com.roady.roadyapi.roadmap.adaptor.input.web.data.request

import com.roady.roadyapi.roadmap.domain.RoadmapNode

data class EditRoadmapRequest(
    val idx: Long,
    val name: String? = null,
    val nodes: Set<RoadmapNode>? = null
)