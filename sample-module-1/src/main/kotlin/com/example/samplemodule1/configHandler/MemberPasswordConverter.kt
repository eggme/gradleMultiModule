package com.example.samplemodule1.configHandler

import com.example.samplemodule1.entity.MemberPassword
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.security.MessageDigest

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