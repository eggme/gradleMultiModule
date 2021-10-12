package com.example.samplecore.handler

import com.google.gson.Gson
import com.google.gson.JsonArray
import javax.persistence.AttributeConverter

class JsonArrayConverter: AttributeConverter<JsonArray?, String> {

    private val gson = Gson()

    override fun convertToDatabaseColumn(attribute: JsonArray?): String {
        return attribute.toString()
    }

    override fun convertToEntityAttribute(dbData: String?): JsonArray? {
        return gson.fromJson(dbData, JsonArray::class.java)
    }
}