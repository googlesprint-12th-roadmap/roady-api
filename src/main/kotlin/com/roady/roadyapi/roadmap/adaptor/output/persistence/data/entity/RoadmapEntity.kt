package com.roady.roadyapi.roadmap.adaptor.output.persistence.data.entity

import javax.persistence.*

@Entity
@Table(name = "roadmap")
class RoadmapEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long = 0,
    val ownerIdx: Long,
    val rootIdx: Long,
    val name: String
)