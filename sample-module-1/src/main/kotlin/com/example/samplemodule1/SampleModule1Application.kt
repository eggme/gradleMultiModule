package com.example.samplemodule1

import com.example.samplecore.config.GsonConfig
import com.example.samplecore.config.JpaConfig
import com.example.samplecore.config.WebConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@ComponentScan(basePackages = ["com.example.samplecore", "com.example.samplemodule1"])
@Import(*[JpaConfig::class, WebConfig::class, GsonConfig::class])
private open class SampleModule1Application

fun main(args: Array<String>) {
    runApplication<SampleModule1Application>(*args)
}
