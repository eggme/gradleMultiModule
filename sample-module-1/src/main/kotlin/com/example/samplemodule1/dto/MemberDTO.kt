package com.example.samplemodule1.dto

import com.example.samplemodule1.entity.Event
import com.example.samplemodule1.entity.MemberPassword
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.Serializable
import java.time.LocalDateTime

data class MemberDTO (
    var mno: Long? = null,
    var name: String? = null,
    var age: Int? = null,
    var password: MemberPassword? = null,
    var temp: JsonObject? = null,
    var messages: JsonArray? = null,
    var address: String? = null,
    var tel: String? = null,
    var event: Event? = null,
    var email: String? = null,
    var createAt: LocalDateTime? = null,
    var modifyAt: LocalDateTime? = null
): Serializable