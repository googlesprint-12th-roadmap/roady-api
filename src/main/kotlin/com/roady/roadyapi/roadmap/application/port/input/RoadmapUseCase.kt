package com.roady.roadyapi.roadmap.application.port.input

import com.roady.roadyapi.roadmap.domain.CreateRoadmap

interface RoadmapUseCase {
    fun createRoadmap(create: CreateRoadmap): Long
}
