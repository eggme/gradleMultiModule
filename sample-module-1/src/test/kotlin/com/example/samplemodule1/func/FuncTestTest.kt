package com.example.samplemodule1.func

import com.example.samplemodule1.entity.Member
import com.example.samplemodule1.entity.MemberPassword
import com.example.samplemodule1.repository.MemberRepository
import com.example.samplemodule1.service.MemberService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import java.math.BigInteger
import java.security.MessageDigest

@ExtendWith(SpringExtension::class)
@WebMvcTest
@DataJpaTest
class FuncTestTest(
    @Autowired var memberService: MemberService,
    @Autowired var memberRepository: MemberRepository
){

    @Test
    fun funTest(){
        val savedMember = memberRepository.findById(13).get()
        savedMember.name = "승승준"
        savedMember.password = MemberPassword("1234444")


        val updatedMember = memberService.updateMember(savedMember)
        println(updatedMember)
    //        val func = FuncTest()
//        println(func.apply("승준") { func.increase(3) })
//
//        val member = Member(1, "테스트", 2)
//        println(member)
//
//        val memberPassword = MemberPassword()
//        memberPassword.password = "1234"
//        val messageDigest = MessageDigest.getInstance("SHA-256")
//        messageDigest?.update(memberPassword?.password?.toByteArray())
//        val hex: String = String.format("%064x", BigInteger(1, messageDigest?.digest()))
//
//        println(hex)
//        println(memberPassword)


    }

    fun increase(num: Int) : Int {
        println("num is $num")
        return num + 10
    }
}