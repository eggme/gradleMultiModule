package com.example.samplemodule1.configHandler

import com.example.samplemodule1.entity.MemberPassword
import org.springframework.format.Formatter
import java.util.*

class MemberFormatter: Formatter<MemberPassword> {
    override fun print(`object`: MemberPassword, locale: Locale): String {
        return `object`.password?: ""
    }

    override fun parse(text: String, locale: Locale): MemberPassword {
        val memberPassword = MemberPassword()
        memberPassword.password = text
        return memberPassword
    }
}