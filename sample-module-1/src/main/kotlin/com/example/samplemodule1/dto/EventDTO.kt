package com.example.samplemodule1.dto

import com.example.samplemodule1.entity.Member
import java.io.Serializable
import java.time.LocalDateTime

data class EventDTO (
    var eno: Long? = 0,
    var name: String? = null,
    var createAt: LocalDateTime? = null,
    var modifyAt: LocalDateTime? = null
): Serializable
