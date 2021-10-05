package com.example.samplemodule1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SampleModule1Application

fun main(args: Array<String>) {
    runApplication<SampleModule1Application>(*args)
}
