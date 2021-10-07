package com.example.samplemodule1.config

import com.example.samplemodule1.configHandler.MemberConverter
import com.example.samplemodule1.configHandler.MemberFormatter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig :WebMvcConfigurer{

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(MemberConverter())
        registry.addFormatter(MemberFormatter())
    }
}