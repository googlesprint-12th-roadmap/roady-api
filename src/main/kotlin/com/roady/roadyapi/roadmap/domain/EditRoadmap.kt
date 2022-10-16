package com.roady.roadyapi.roadmap.domain

data class EditRoadmap(
    val idx: Long,
    val accountIdx: Long,
    val name: String? = null,
    val nodes: Set<RoadmapNode>? = null
)