package com.example.samplecore.dto

import java.io.Serializable
import java.time.LocalDateTime

data class EventDTO (
    var eno: Int? = 0,
    var name: String? = null,
    var createAt: LocalDateTime? = null,
    var modifyAt: LocalDateTime? = null
): Serializable
