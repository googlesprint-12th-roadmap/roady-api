package com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity

import com.roady.roadyapi.roadmap.domain.NodeType
import javax.persistence.*

@Entity
@Table(name = "roadmap_node")
class RoadmapNodeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long = 0,
    val roadmapIdx: Long,
    val title: String,
    @Column(name = "description") val desc: String,
    val url: String,
    @Enumerated(EnumType.STRING)
    val type: NodeType,
    @ElementCollection(fetch = FetchType.EAGER)
    val children: Set<Long>,
    val parent: Long
)