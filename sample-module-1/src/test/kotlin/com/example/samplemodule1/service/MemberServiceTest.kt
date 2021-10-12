package com.example.samplemodule1.service

import com.example.samplemodule1.entity.MemberPassword
import com.example.samplemodule1.repository.MemberRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.transaction.Transactional

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class MemberServiceTest (
//    @Autowired var memberService: MemberService,
//    @Autowired var memberRepository: MemberRepository
        ){

        @Test
        @Transactional
        fun updateMemberTest() {
//            val savedMember = memberRepository.findById(13).get()
//            savedMember.name = "상승준"
//            savedMember.password = MemberPassword("123444445")
//            savedMember.address = "광주광역시"
//            println(savedMember)
//
//
//            val updatedMember = memberService.updateMember(savedMember)
//            println("updateMember $updatedMember")
        }

}