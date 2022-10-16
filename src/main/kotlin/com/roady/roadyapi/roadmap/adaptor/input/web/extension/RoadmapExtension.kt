package com.roady.roadyapi.roadmap.adaptor.input.web.extension

import com.roady.roadyapi.roadmap.adaptor.input.web.data.request.CreateRoadmapRequest
import com.roady.roadyapi.roadmap.adaptor.input.web.data.request.EditRoadmapRequest
import com.roady.roadyapi.roadmap.domain.CreateRoadmap
import com.roady.roadyapi.roadmap.domain.EditRoadmap

fun CreateRoadmapRequest.toDomain(accountIdx: Long) = CreateRoadmap(
    name = name,
    ownerIdx = accountIdx,
    rootIdx = rootIdx,
    nodes = nodes
)

fun EditRoadmapRequest.toDomain(roadmapIdx: Long, accountIdx: Long) = EditRoadmap(
    roadmapIdx,
    accountIdx,
    name,
    nodes
)