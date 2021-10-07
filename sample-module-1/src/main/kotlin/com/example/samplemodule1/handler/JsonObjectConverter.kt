package com.example.samplemodule1.handler

import com.google.gson.Gson
import com.google.gson.JsonObject
import javax.persistence.AttributeConverter

class JsonObjectConverter: AttributeConverter<JsonObject?, String> {

    private val gson = Gson()

    override fun convertToDatabaseColumn(attribute: JsonObject?): String {
        return attribute.toString()
    }

    override fun convertToEntityAttribute(dbData: String?): JsonObject? {
        return gson.fromJson(dbData, JsonObject::class.java)
    }
}