package com.roady.roadyapi.roadmap.domain

data class RoadmapNode(
    val idx: Long,
    val title: String,
    val desc: String,
    val url: String,
    val type: NodeType,
    val children: Set<Long>,
    val parent: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RoadmapNode

        if (idx != other.idx) return false

        return true
    }

    override fun hashCode(): Int {
        return idx.hashCode()
    }
}