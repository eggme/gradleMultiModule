package com.example.samplemodule1.configHandler

import com.example.samplemodule1.entity.MemberPassword
import org.springframework.core.convert.converter.Converter

class MemberConverter : Converter<String, MemberPassword>{
    override fun convert(source: String): MemberPassword? {
        println(source)
        val memberPassword = MemberPassword()
        memberPassword.password = source
        return memberPassword
    }
}