package com.example.sampleauth

import com.example.samplecore.config.JpaConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(JpaConfig::class)
class SampleAuthApplication

fun main(args: Array<String>) {
    runApplication<SampleAuthApplication>(*args)
}
