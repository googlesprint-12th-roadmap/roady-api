package com.roady.roadyapi.roadmap.domain

data class CreateRoadmap(
    val name: String,
    val ownerIdx: Long,
    val rootIdx: Long,
    val nodes: List<RoadmapNode>
)