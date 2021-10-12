package com.example.samplemodule1.config

import com.example.samplemodule1.adapter.LocalDateTimeAdapter
import com.google.gson.GsonBuilder
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter
import java.time.LocalDateTime

@Configuration
class GsonConfiguration {

    @Bean
    fun customConverter(): HttpMessageConverters? {
        val messageConverters : MutableCollection<HttpMessageConverter<*>> = ArrayList()
        val gson = GsonBuilder()
            .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeAdapter())
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create()

        val gsonHttpMessageConverter = GsonHttpMessageConverter(gson)
        messageConverters.add(gsonHttpMessageConverter)

        return HttpMessageConverters(true, messageConverters)
    }
}

/**
Converter와 Formatter 이 두 데이터 바인딩 인터페이스는 위에서 WebMvcConfigurer의 메서드를 통해 ConversionService에 등록된다. ConversionService는 실제 데이터 변환이 일어나는 곳이며 이 ConversionService를 통해 데이터 바인딩이 일어나게 된다. 참고로 스프링 부트에서는 ConversionService는 WebConversionService 스프링 빈으로 자동 주입된다. (WebConversionService는 DefaultFormattingConversionService를 상속받은 클래스)
스프링 부트가 제공하는 클래스인 WebConversionService는 Formatter와 Converter를 자동으로 등록해준다. 따라서 위에 Converter와 Formatter를 등록하기 위해 만들었던 WebMvcConfigurer를 작성할 필요가 없다. (즉, Formatter와 Converter를 스프링 빈으로 등록하면 자동적으로 ConversionService에 등록되게 된다)


 */