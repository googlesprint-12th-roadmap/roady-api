package com.roady.roadyapi.roadmap.adaptor.input.web.extension

import com.roady.roadyapi.roadmap.adaptor.input.web.data.request.CreateRoadmapRequest
import com.roady.roadyapi.roadmap.domain.CreateRoadmap

fun CreateRoadmapRequest.toDomain(accountIdx: Long) = CreateRoadmap(
    name = name,
    ownerIdx = accountIdx,
    nodes = nodes
)