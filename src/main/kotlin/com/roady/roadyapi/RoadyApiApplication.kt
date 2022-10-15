package com.roady.roadyapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RoadyApiApplication

fun main(args: Array<String>) {
    runApplication<RoadyApiApplication>(*args)
}
