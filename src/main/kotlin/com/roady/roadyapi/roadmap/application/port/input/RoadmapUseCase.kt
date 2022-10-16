package com.roady.roadyapi.roadmap.application.port.input

import com.roady.roadyapi.roadmap.domain.CreateRoadmap
import com.roady.roadyapi.roadmap.domain.DeleteRoadmap
import com.roady.roadyapi.roadmap.domain.EditRoadmap

interface RoadmapUseCase {
    fun createRoadmap(create: CreateRoadmap): Long
    fun editRoadmap(edit: EditRoadmap): Long
    fun deleteRoadmap(delete: DeleteRoadmap)
}
