package com.example.samplecore.configHandler

import com.example.samplecore.entity.MemberPassword
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

class MemberPasswordConverter {

    @Component
    class StringToMemberPasswordConverter: Converter<String, MemberPassword> {
        override fun convert(source: String): MemberPassword? {

            //val memberPassword: MemberPassword()
            return null
        }
    }

    @Component
    class MemberPasswordToStringConverter: Converter<MemberPassword, String> {
        override fun convert(source: MemberPassword): String? {
            TODO("Not yet implemented")
        }
    }
}