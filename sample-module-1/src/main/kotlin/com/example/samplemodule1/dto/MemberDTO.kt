package com.example.samplemodule1.dto

import java.io.Serializable

data class MemberDTO (
    var id: Long? = null,
    var name: String? = null,
    var age: Int? = null
): Serializable