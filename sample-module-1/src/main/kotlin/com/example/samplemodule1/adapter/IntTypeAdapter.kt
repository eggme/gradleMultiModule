package com.example.samplemodule1.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class IntTypeAdapter: TypeAdapter<Number>() {

    override fun write(out: JsonWriter?, value: Number?) {
        TODO("Not yet implemented")
    }

    override fun read(`in`: JsonReader?): Number {
        TODO("Not yet implemented")
    }
}