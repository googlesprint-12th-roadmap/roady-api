package com.roady.roadyapi.roadmap.domain

data class Roadmap(
    val id: Long,
    val name: String,
    val nodes: Set<RoadmapNode>,
    val rootId: Long
)