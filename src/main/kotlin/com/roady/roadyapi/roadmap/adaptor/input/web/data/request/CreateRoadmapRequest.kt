package com.roady.roadyapi.roadmap.adaptor.input.web.data.request

import com.roady.roadyapi.roadmap.domain.RoadmapNode

data class CreateRoadmapRequest(
    val name: String,
    val nodes: List<RoadmapNode>
)