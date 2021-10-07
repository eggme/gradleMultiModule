package com.example.samplemodule1.handler

import com.google.gson.Gson
import com.google.gson.JsonArray
import javax.persistence.AttributeConverter
import javax.persistence.Converter

class JsonArrayConverter: AttributeConverter<JsonArray?, String> {

    private val gson = Gson()

    override fun convertToDatabaseColumn(attribute: JsonArray?): String {
        return attribute.toString()
    }

    override fun convertToEntityAttribute(dbData: String?): JsonArray? {
        return gson.fromJson(dbData, JsonArray::class.java)
    }
}