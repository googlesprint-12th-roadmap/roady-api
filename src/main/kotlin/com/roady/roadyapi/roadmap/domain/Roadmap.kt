package com.roady.roadyapi.roadmap.domain

data class Roadmap(
    val idx: Long = System.currentTimeMillis(),
    val ownerIdx: Long,
    val rootIdx: Long,
    val name: String,
    val nodes: Set<RoadmapNode>
)