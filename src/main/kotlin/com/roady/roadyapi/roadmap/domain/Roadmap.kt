package com.roady.roadyapi.roadmap.domain

data class Roadmap(
    val idx: Long = 0,
    val ownerIdx: Long,
    val rootIdx: Long,
    val name: String,
    val nodes: Set<RoadmapNode>
)