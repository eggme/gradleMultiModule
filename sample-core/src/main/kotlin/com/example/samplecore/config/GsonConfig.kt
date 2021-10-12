package com.example.samplecore.config

import com.example.samplecore.adapter.LocalDateAdapter
import com.example.samplecore.adapter.LocalDateTimeAdapter
import com.google.gson.GsonBuilder
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter
import java.time.LocalDate
import java.time.LocalDateTime

class GsonConfig {

    @Bean
    fun customConverters() : HttpMessageConverters? {
        val messageConverters: MutableCollection<HttpMessageConverter<*>> = ArrayList()
        val gson = GsonBuilder()
            .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeAdapter())
            .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter())
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create()

        val gsonHttpMessageConverter = GsonHttpMessageConverter(gson)
        messageConverters.add(gsonHttpMessageConverter)

        return HttpMessageConverters(true, messageConverters)
    }
}