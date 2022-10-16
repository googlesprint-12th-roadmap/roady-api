package com.roady.roadyapi.roadmap.adaptor.input.web.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("roady.roadmap")
data class RoadmapProperty(val guestAccountIdx: Long)