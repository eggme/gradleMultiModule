package com.example.samplecore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SampleCoreApplication

fun main(args: Array<String>) {
    runApplication<SampleCoreApplication>(*args)
}
