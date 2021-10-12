package com.example.samplecore.controller

import com.example.samplecore.entity.MemberEntity
import com.example.samplecore.reposiroty.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestCoreController {

    @Autowired private lateinit var memberRepository: MemberRepository

    @PostMapping(value = ["/testCore"])
    fun testCore(@RequestBody member: MemberEntity): ResponseEntity<Any>{
        println(member)
        val savedMember = memberRepository.save(member)
        return ResponseEntity.ok(mapOf("test" to "success", "member" to savedMember))
    }
}