package com.roady.roadyapi.roadmap.domain

data class CreateRoadmap(
    val name: String,
    val ownerIdx: Long,
    val nodes: List<RoadmapNode>
)