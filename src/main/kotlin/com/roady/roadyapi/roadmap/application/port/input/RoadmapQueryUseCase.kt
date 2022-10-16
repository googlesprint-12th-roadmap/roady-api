package com.roady.roadyapi.roadmap.application.port.input

import com.roady.roadyapi.roadmap.domain.Roadmap

interface RoadmapQueryUseCase {
    fun findById(idx: Long): Roadmap
}
