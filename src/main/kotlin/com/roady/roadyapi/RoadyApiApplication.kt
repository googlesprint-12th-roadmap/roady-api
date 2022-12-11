package com.roady.roadyapi

import com.roady.roadyapi.roadmap.adaptor.input.web.property.RoadmapProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RoadmapProperty::class)
class RoadyApiApplication

fun main(args: Array<String>) {
    runApplication<RoadyApiApplication>(*args)
}
