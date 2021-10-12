package com.example.samplemodule1

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SampleModule1ApplicationTests {

    @Test
    fun contextLoads() {
        println(150000.times(10).div(100))
    }

}
